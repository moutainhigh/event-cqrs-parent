package com.hack.core.lmax;

import com.hack.core.event.BasicEventFactory;
import com.hack.core.event.DataFlowHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.stream.IntStream;

public class DisruptorFactory {

    public static Disruptor createDisruptor(int bufferSize, int handlerSize) {
        BasicEventFactory objectBasicEventFactory = new BasicEventFactory<>();
        Disruptor disruptor = new Disruptor(objectBasicEventFactory, bufferSize, DaemonThreadFactory.INSTANCE);
        DataFlowHandler[] dataFlowHandlers = IntStream.range(0, handlerSize).mapToObj(i -> new DataFlowHandler(i + "")).toArray(DataFlowHandler[]::new);
        disruptor.handleEventsWithWorkerPool(dataFlowHandlers);
        disruptor.start();
        return disruptor;
    }
}
