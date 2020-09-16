package com.hack.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class TradePojo {

    private long tradeId;
    private String cusip;

    private String trader;
    private String salesPerson;

    public TradePojo() {
    }

    public TradePojo(long tradeId, String cusip, String trader, String salesPerson) {
        this.tradeId = tradeId;
        this.cusip = cusip;
        this.trader = trader;
        this.salesPerson = salesPerson;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }
}
