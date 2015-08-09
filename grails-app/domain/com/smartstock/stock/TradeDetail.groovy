package com.smartstock.stock

import com.smartstock.type.TradeType

class TradeDetail implements Serializable {

    Long stockId
    Long tradeTime
    TradeType type
    Float price
    Float changeAmount
    Long volume //成交量
    Long amountOfMoney //成交金额

    static constraints = {
        price nullable: true
        changeAmount nullable: true
        volume nullable: true
        amountOfMoney nullable: true
    }

    static mapping = {
        version(false)
        id composite: ['stockId', 'tradeTime']
        stockId index: 'TradeDetail_StockId_Idx'
        tradeTime index: 'TradeDetail_TradeTime_Idx'
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof TradeDetail)) return false
        TradeDetail that = (TradeDetail) o
        if (stockId != that.stockId) return false
        if (tradeTime != that.tradeTime) return false
        return true
    }

    int hashCode() {
        int result
        result = stockId.hashCode()
        result = 31 * result + tradeTime.hashCode()
        return result
    }
}
