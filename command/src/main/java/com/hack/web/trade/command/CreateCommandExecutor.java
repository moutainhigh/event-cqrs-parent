package com.hack.web.trade.command;

import com.hack.web.base.CommandExecutor;
import com.hack.web.trade.domain.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class CreateCommandExecutor implements CommandExecutor<CreateTradeCommand, Long> {

    @Autowired
    private TradeService tradeService;


    public Long execute(CreateTradeCommand createTradeCommand) {
        validate(createTradeCommand);
        return tradeService.create(createTradeCommand).getTradeId();
    }

    private void validate(CreateTradeCommand createTradeCommand) {

    }

    @Override
    public boolean match(Object obj) {
        return obj instanceof CreateTradeCommand;
    }
}
