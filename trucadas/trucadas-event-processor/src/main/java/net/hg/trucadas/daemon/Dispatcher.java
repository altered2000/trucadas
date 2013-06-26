package net.hg.trucadas.daemon;

import java.util.Set;

import net.hg.trucadas.model.domain.freeswitch.FreeSwitchServer;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Dispatcher {

    public static final String BEAN_NAME = Dispatcher.class.getSimpleName();

    private Set<FreeSwitchServer> servers;

    private ThreadPoolTaskExecutor workQueueExecutor;

    public Set<FreeSwitchServer> getServers() {
        return servers;
    }

    public void setServers(Set<FreeSwitchServer> servers) {
        this.servers = servers;
    }

    public void start() {
        for (FreeSwitchServer server : servers) {
            workQueueExecutor.execute(new Runnable() {
                public void run() {
                }
            });

        }
    }
}
