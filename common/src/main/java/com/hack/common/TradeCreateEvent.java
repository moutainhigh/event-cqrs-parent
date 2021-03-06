package com.hack.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeCreateEvent {

    private long tradeId;
    private String cusip;

    private String trader;
    private String salePerson;

    private TradeStatus status;


}
