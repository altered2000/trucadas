package net.hg.trucadas.model.domain;

import java.io.Serializable;
import java.util.Map;

public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uuid;

	private String eventName;

	private Map<String, String> headers;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public static Event build(EslEvent event) {
EventController.
		return new Event();
		
	}

}
