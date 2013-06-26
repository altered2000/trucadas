package net.hg.trucadas.model.domain.event;

import java.io.Serializable;
import java.util.Map;

import org.freeswitch.esl.client.transport.event.EslEvent;

/**
 * 
 * @author hgeraldino
 *
 */
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uuid;

    private String eventName;

    private Long timestamp;

    private Map<String, String> headers;

    public String getUuid() {
        return uuid;
    }

    public Event setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getEventName() {
        return eventName;
    }

    public Event setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Event setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Event setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public static Event build(EslEvent eslEvent) {
        Event event = new Event().setEventName(eslEvent.getEventName()).setTimestamp(eslEvent.getEventDateTimestamp());
        event.setHeaders(eslEvent.getEventHeaders());
        return event;
    }
}
