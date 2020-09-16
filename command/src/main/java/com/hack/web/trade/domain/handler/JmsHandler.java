package com.hack.web.trade.domain.handler;

import com.hack.common.TradeCreateEvent;
import com.hack.core.aspectj.LmaxAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class JmsHandler {


    //这里模拟下发送kafka
    @EventListener
    @LmaxAsync
    public void onEvent(TradeCreateEvent tradeCreateEvent){
        mockKafka(tradeCreateEvent);
    }

    public void mockKafka(TradeCreateEvent tradeCreateEvent){
        log.info("send to kafka:{}",tradeCreateEvent);
        RestTemplate restTemplate = new RestTemplate();
        // 发送到Q 端
        ResponseEntity<Void> voidResponseEntity = restTemplate.postForEntity("http://localhost:1102/onEvent", tradeCreateEvent, Void.class);
        Assert.isTrue(voidResponseEntity.getStatusCode().is2xxSuccessful(),"mock service fail");
    }
}
