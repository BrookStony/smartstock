package com.smartstock.stock.statistics

class StockMonthStat extends BaseStat {

    Integer year
    Integer month
    Long stockId
    Long datetime
    Float m5Price = 0.0f
    Float m10Price = 0.0f
    Float m20Price = 0.0f
    Float m30Price = 0.0f
    Float m60Price = 0.0f

    static constraints = {
    }

    static mapping = {
        version(false)
        id composite: ['stockId', 'datetime']
        stockId index: 'StockMonthStat_StockId_Idx'
        datetime index: 'StockMonthStat_DateTime_Idx'
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof StockMonthStat)) return false
        StockMonthStat that = (StockMonthStat) o
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
