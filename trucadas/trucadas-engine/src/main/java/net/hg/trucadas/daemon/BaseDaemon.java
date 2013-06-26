package net.hg.trucadas.daemon;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class BaseDaemon {

    public Log log = LogFactory.getLog(getClass());

    private FileSystemXmlApplicationContext ctx;

    public ApplicationContext getSpringContext() {
        return ctx;
    }


    public void init(String[] configs) {
        try {
            if (configs.length < 1) {
                System.err.println("Usage: java " + getClass().getName() + " <spring files>");
                System.exit(1);
            }

            initConfiguration(configs);
            postStartup();

        } catch (Throwable t) {
            log.fatal("Startup failed", t);
            System.exit(1);
        }
    }
    
    public abstract void postStartup();

    private void initConfiguration(String[] springBeanDefs) {
        Set<String> files = new HashSet<String>();

        for (String f : springBeanDefs) {
            if (new File(f).exists()) {
                files.add(f);
            } else {
                log.info(f + " does not exist.  Skipping");
            }
        }

        if (log.isInfoEnabled()) {
            log.info("Starting with bean-defs: " + files);
        }

        this.ctx = new FileSystemXmlApplicationContext(files.toArray(new String[] {}));
        this.ctx.registerShutdownHook();
    }
}
