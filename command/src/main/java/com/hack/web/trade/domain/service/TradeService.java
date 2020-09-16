package com.hack.web.trade.domain.service;

import com.hack.web.trade.command.CreateTradeCommand;
import com.hack.web.trade.domain.dao.TradeEntity;
import com.hack.web.trade.domain.dao.TradeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public TradeEntity create(CreateTradeCommand createTradeCommand) {
        TradeEntity tradeEntity = new TradeEntity();
        BeanUtils.copyProperties(createTradeCommand, tradeEntity);
        tradeRepository.save(tradeEntity);
        return tradeEntity;
    }
}
