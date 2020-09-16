package com.hack.web.trade.domain.service;

import com.hack.common.TradeCreateEvent;
import com.hack.core.event.DataFlowEvent;
import com.hack.core.event.EventMultiCaster;
import com.hack.web.trade.command.CreateTradeCommand;
import com.hack.web.trade.domain.dao.TradeEntity;
import com.hack.web.trade.domain.dao.TradeRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private RefDataService refDataService;

    @Autowired
    private EventMultiCaster eventMultiCaster;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public TradeEntity create(CreateTradeCommand createTradeCommand) {
        TradeEntity tradeEntity = new TradeEntity();
        BeanUtils.copyProperties(createTradeCommand, tradeEntity);
        tradeRepository.save(tradeEntity);
        //异步执行
        eventMultiCaster.asyncMulticastFlowEvent(DataFlowEvent.<TradeEntity>builder()
                .data(tradeEntity)
                .subscribe(event -> refDataService.callRefData())
                .onCompleted(event -> {
                    // 这里发送spring 事件
                    TradeCreateEvent tradeCreateEvent = new TradeCreateEvent();
                    BeanUtils.copyProperties(event, tradeCreateEvent);
                    applicationEventPublisher.publishEvent(tradeCreateEvent);})
                .onError((event, e) -> log.error("create trade error", e))
                .build());
        return tradeEntity;
    }
}
