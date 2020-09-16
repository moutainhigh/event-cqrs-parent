package com.hack.core.config;

import com.hack.core.event.DataFlowEvent;
import com.hack.core.event.EventMultiCaster;
import com.hack.core.lmax.DisruptorFactory;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@Configuration
public class HackAutoConfig {

    @Bean
    @ConditionalOnProperty(name = "hack.lmax.enable",havingValue = "true")
    @ConfigurationProperties("hack.lmax")
    public RingBufferProperties ringBufferProperties(){
        return new RingBufferProperties();

    }

    @Bean
    @ConditionalOnBean(RingBufferProperties.class)
    public RingBufferWrapper<DataFlowEvent> dataFlowEventRingBufferWrapper(RingBufferProperties ringBufferProperties){
        Assert.isTrue(ringBufferProperties.getBufferSize()>0,"buffer size must great than 0");
        Assert.isTrue(ringBufferProperties.getHandlerSize()>0,"handler size must great than 0");
        Disruptor<DataFlowEvent> disruptor = DisruptorFactory.createDisruptor(ringBufferProperties.getBufferSize(), ringBufferProperties.getHandlerSize());
        return RingBufferWrapper.<DataFlowEvent>builder().disruptor(disruptor).build();
    }

    @Bean
    public <T>EventMultiCaster eventMultiCaster(RingBufferWrapper<DataFlowEvent> ringBufferWrapper){
        return EventMultiCaster.builder().ringBufferWrapper(ringBufferWrapper).build();
    }
}
