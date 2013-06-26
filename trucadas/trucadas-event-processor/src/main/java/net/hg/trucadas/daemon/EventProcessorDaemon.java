package net.hg.trucadas.daemon;

/**
 * 
 * @author hgeraldino
 * 
 */
public class EventProcessorDaemon extends BaseDaemon {

    // private static final Logger logger = Logger
    // .getLogger(ElizaListenerDaemon.class);

    public static void main(String[] args) {
        EventProcessorDaemon daemon = new EventProcessorDaemon();
        daemon.init(args);
    }

    @Override
    public void postStartup() {
        ConnectionCoordinator coordinator = (ConnectionCoordinator) this.getSpringContext().getBean(ConnectionCoordinator.BEAN_NAME);
        coordinator.start();
    }
}
