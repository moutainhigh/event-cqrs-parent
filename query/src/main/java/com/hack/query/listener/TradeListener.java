package com.hack.query.listener;

import com.hack.common.TradePojo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class TradeListener {

    private Map<Long,TradePojo> cache=new ConcurrentHashMap();

    /**
     * mock kafka 的监听
     */
    @RequestMapping("onEvent")
    public void onEvent(TradePojo tradePojo){
        cache.put(tradePojo.getTradeId(),tradePojo);
    }

    @RequestMapping("find/{tradeId}")
    public Mono<TradePojo> findById(@PathVariable long tradeId){
        return Mono.just(cache.get(tradeId));

    }
}
