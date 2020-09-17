package com.hack.web.trade.domain.service;

import com.hack.common.TradeCreateEvent;
import com.hack.common.TradeStatus;
import com.hack.web.trade.domain.dao.TradeEntity;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RefDataService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public void callRefData(TradeEntity tradeEntity){
        TradeCreateEvent tradeCreateEvent = new TradeCreateEvent();
        BeanUtils.copyProperties(tradeEntity, tradeCreateEvent);
        applicationEventPublisher.publishEvent(tradeCreateEvent);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
}
