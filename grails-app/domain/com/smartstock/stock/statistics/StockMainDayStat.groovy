package com.smartstock.stock.statistics

/**
 * Created by Administrator on 2015/7/3.
 */
class StockMainDayStat extends BaseMainStat {

    Long stockId
    Long datetime

    static constraints = {
    }

    static mapping = {
        version(false)
        id composite: ['stockId', 'datetime']
        stockId index: 'StockMainDayStat_StockId_Idx'
        datetime index: 'StockMainDayStat_DateTime_Idx'
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof StockMainDayStat)) return false
        StockMainDayStat that = (StockMainDayStat) o
        if (stockId != that.stockId) return false
        if (datetime != that.datetime) return false
        return true
    }

    int hashCode() {
        int result
        result = stockId.hashCode()
        result = 31 * result + datetime.hashCode()
        return result
    }
}
