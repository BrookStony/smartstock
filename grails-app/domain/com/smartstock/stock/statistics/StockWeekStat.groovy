package com.smartstock.stock.statistics

class StockWeekStat extends BaseStat {

    Integer year
    Integer week
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
        stockId index: 'StockWeekStat_StockId_Idx'
        datetime index: 'StockWeekStat_DateTime_Idx'
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof StockWeekStat)) return false
        StockWeekStat that = (StockWeekStat) o
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
