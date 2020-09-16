package com.hack.web.trade.domain.event;

import com.hack.common.TradeCreateEvent;
import com.hack.core.aspectj.LmaxAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailHandler {


    /**
     * 异步的事件
     * @param tradeCreateEvent
     */
    @EventListener
    @LmaxAsync
    public void onEvent(TradeCreateEvent tradeCreateEvent){
        log.info("email handler:{}",tradeCreateEvent);
    }
}
