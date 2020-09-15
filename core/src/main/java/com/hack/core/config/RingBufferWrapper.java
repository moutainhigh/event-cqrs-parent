package com.hack.core.config;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RingBufferWrapper<DataFlowEvent> implements DisposableBean {

    private Disruptor<DataFlowEvent> disruptor;

    private RingBuffer<DataFlowEvent> ringBuffer;

    @Override
    public void destroy() throws Exception {
        Optional.ofNullable(disruptor).ifPresent(Disruptor::shutdown);

    }
}
