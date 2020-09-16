package com.hack.web.trade;

import com.hack.web.base.CommandBus;
import com.hack.web.trade.command.CreateTradeCommand;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("trade")
public class TradeController {

    @Autowired
    private CommandBus commandBus;

    @PostMapping("create")
    @ApiOperation("创建trade")
    public Long creteTrade(@RequestBody CreateTradeCommand createTradeCommand) {
        return commandBus.execute(createTradeCommand,Long.class);
    }
}
