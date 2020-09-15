package com.hack.core.event;

import com.hack.core.config.RingBufferWrapper;
import lombok.Builder;
import org.springframework.beans.BeanUtils;

@Builder
public class EventMultiCaster {

    private RingBufferWrapper<DataFlowEvent> ringBufferWrapper;

    /**
     * 发布事件
     * @param flowEvent
     * @param <T>
     */
    public <T> void asyncMulticastFlowEvent(DataFlowEvent<T> flowEvent) {
        ringBufferWrapper.getDisruptor().publishEvent((event, seq, data) -> {
            BeanUtils.copyProperties(data, event);
            event.setSequence(seq);
        }, flowEvent);
    }
}
