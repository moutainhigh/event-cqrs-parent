package com.hack.core.event;

import com.lmax.disruptor.WorkHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DataFlowHandler<T> implements WorkHandler<DataFlowEvent<T>> {

    private String handlerName;

    @Override
    public void onEvent(DataFlowEvent<T> event) throws Exception {
        log.info("work handler start:{}",handlerName);
        event.execute();
    }
}
