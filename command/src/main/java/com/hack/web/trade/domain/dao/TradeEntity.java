package com.hack.web.trade.domain.dao;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TradeEntity {

    @Id
    @GeneratedValue
    private long tradeId;

    private String cusip;

    private String trader;
    private String salePerson;

}
