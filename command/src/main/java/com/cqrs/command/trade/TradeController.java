package com.cqrs.command.trade;

import com.cqrs.command.base.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("trade")
public class TradeController {

    @Autowired
    private CommandBus commandBus;

    @PostMapping("create")
    public Long creteTrade(@RequestBody CreateTradeCommand createTradeCommand) {
        return commandBus.execute(createTradeCommand,Long.class);
    }
}
