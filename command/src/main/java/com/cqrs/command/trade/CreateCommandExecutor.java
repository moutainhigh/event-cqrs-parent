package com.cqrs.command.trade;

import com.cqrs.command.base.CommandExecutor;
import com.cqrs.command.trade.domain.service.TradeService;
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
