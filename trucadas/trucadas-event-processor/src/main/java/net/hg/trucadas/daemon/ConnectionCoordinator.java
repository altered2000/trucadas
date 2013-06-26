package net.hg.trucadas.daemon;

import java.util.Set;

import net.hg.trucadas.model.domain.freeswitch.FreeSwitchServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ConnectionCoordinator {

    public static final String BEAN_NAME = ConnectionCoordinator.class.getSimpleName();

    @Autowired
    private Set<FreeSwitchServer> servers;

    private ThreadPoolTaskExecutor workQueueExecutor;

    public void start() {
        for (FreeSwitchServer server : servers) {
            workQueueExecutor.execute(new Runnable() {
                public void run() {
                }
            });

        }
    }
}
