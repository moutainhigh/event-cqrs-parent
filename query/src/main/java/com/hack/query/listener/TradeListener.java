package com.hack.query.listener;

import com.hack.common.TradeCreateEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class TradeListener {

    private Map<Long, TradeCreateEvent> cache = new ConcurrentHashMap();

    /**
     * mock kafka 的监听
     */
    @PostMapping("onEvent")
    public void onEvent(@RequestBody TradeCreateEvent tradeCreateEvent) {
        cache.put(tradeCreateEvent.getTradeId(), tradeCreateEvent);
    }

    @GetMapping("find/{tradeId}")
    public Mono<TradeCreateEvent> findById(@PathVariable long tradeId) {
        return Mono.justOrEmpty(cache.get(tradeId));
    }
}
