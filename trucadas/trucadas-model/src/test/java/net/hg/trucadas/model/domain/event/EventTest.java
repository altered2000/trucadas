package net.hg.trucadas.model.domain.event;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.freeswitch.esl.client.transport.event.EslEvent;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

/**
 * @author hgeraldino
 * 
 */
public class EventTest {
    private EslEvent eslEvent;

    @Before
    public void setup() {
        eslEvent = mock(EslEvent.class);
        when(eslEvent.getEventDateTimestamp()).thenReturn(System.currentTimeMillis());
        when(eslEvent.getEventName()).thenReturn("BACKGROUND_JOB");
        when(eslEvent.getEventDateGmt()).thenReturn("Thu, 01 May 2008 23:37:03 GMT");
        when(eslEvent.getEventDateLocal()).thenReturn("2008-05-02 07:37:03");
        when(eslEvent.getEventHeaders()).thenReturn(ImmutableMap.<String, String> builder().put("Event-Name", "BACKGROUND_JOB") //
                .put("Event-Calling-Function", "api_exec") //
                .put("Event-Date-GMT", "Thu, 01 May 2008 23:37:03 GMT") //
                .put("Core-UUID", "2bdf272-16e6-11dd-b7a0-db4edd065621") //
                .put("Job-Command-Arg", "sofia/default/1005 '&park'") //
                .put("Content-Length", "41") //
                .put("FreeSWITCH-IPv4", "192.168.1.104") //
                .put("Event-Date-Local", "2008-05-02 07:37:03") //
                .put("Job-Command", "originate") //
                .put("FreeSWITCH-IPv6", "127.0.0.1") //
                .put("Job-UUID", "7f4db78a-17d7-11dd-b7a0-db4edd065621") // 
                .put("Event-Calling-File", "mod_event_socket.c") //
                .put("Event-Date-Timestamp", "1209685023894968") //
                .put("FreeSWITCH-Hostname", "localhost") //
                .put("Event-Calling-Line-Number", "609").build());
    }

    @Test
    public void testBackgroundEvent() {
        Event event = Event.build(eslEvent);

        assertNotNull(event);
        Assert.assertEquals(event.getEventName(), "BACKGROUND_JOB");
        Assert.assertEquals(event.getHeaders().size(), 15);

    }

}
