package com.hack.core.event;

import com.lmax.disruptor.EventFactory;

public class BasicEventFactory<T> implements EventFactory<DataFlowEvent<T>> {
    @Override
    public DataFlowEvent<T> newInstance() {
        return new DataFlowEvent<>();
    }
}
