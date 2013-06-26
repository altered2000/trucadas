package net.hg.trucadas.service;

import net.hg.trucadas.model.domain.event.Event;

public interface EventProcessorService {

	Event setEventController(Event event);
	
}
