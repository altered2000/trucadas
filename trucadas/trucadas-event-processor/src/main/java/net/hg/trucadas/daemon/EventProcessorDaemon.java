package net.hg.trucadas.daemon;


public class EventProcessorDaemon extends BaseDaemon {

//	private static final Logger logger = Logger
//			.getLogger(ElizaListenerDaemon.class);

	public static void main(String[] args) {

		new EventProcessorDaemon().startup(args);
	}

}
