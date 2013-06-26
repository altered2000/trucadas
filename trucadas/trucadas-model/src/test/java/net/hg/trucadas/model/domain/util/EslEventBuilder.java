package net.hg.trucadas.model.domain.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.freeswitch.esl.client.transport.event.EslEvent;
import org.freeswitch.esl.client.transport.message.EslFrameDecoder;
import org.freeswitch.esl.client.transport.message.EslMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.handler.codec.embedder.DecoderEmbedder;

/**
 * 
 * @author hgeraldino
 * 
 */
public class EslEventBuilder {

    private static DecoderEmbedder<EslMessage> embedder = new DecoderEmbedder<EslMessage>(new EslFrameDecoder(64));

    public static EslEvent buildBackGroundJobEslEvent() {
        List<String> inputLines = new ArrayList<String>();
        inputLines.add("Content-Length: 582");
        inputLines.add("Content-Type: text/event-plain");
        inputLines.add("");
        inputLines.add("Job-UUID: 7f4db78a-17d7-11dd-b7a0-db4edd065621");
        inputLines.add("Job-Command: originate");
        inputLines.add("Job-Command-Arg: sofia/default/1005%20'%26park'");
        inputLines.add("Event-Name: BACKGROUND_JOB");
        inputLines.add("Core-UUID: 42bdf272-16e6-11dd-b7a0-db4edd065621");
        inputLines.add("FreeSWITCH-Hostname: ser");
        inputLines.add("FreeSWITCH-IPv4: 192.168.1.104");
        inputLines.add("FreeSWITCH-IPv6: 127.0.0.1");
        inputLines.add("Event-Date-Local: 2008-05-02%2007%3A37%3A03");
        inputLines.add("Event-Date-GMT: Thu,%2001%20May%202008%2023%3A37%3A03%20GMT");
        inputLines.add("Event-Date-Timestamp: 1209685023894968");
        inputLines.add("Event-Calling-File: mod_event_socket.c");
        inputLines.add("Event-Calling-Function: api_exec");
        inputLines.add("Event-Calling-Line-Number: 609");
        inputLines.add("Content-Length: 41");
        inputLines.add("");
        inputLines.add("+OK 7f4de4bc-17d7-11dd-b7a0-db4edd065621");

        embedder.offer(createInputBuffer(inputLines, false));

        EslMessage result = embedder.poll();
        embedder.finish();

        return new EslEvent(result);
    }

    private static ChannelBuffer createInputBuffer(List<String> inputLines, boolean terminateLastLine) {
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();

        Iterator<String> it = inputLines.iterator();
        while (it.hasNext()) {
            buffer.writeBytes(it.next().getBytes());
            // only terminate last line if asked
            if (it.hasNext() || terminateLastLine) {
                buffer.writeByte('\n');
            }
        }
        return buffer;
    }
}
