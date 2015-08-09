package com.smartstock.stock.statistics

class StockDayStat extends BaseStat {

    Long stockId
    Long datetime
    Float pe = 0.0f    //市盈率（earnings multiple，即P/E ratio）
    Float pb = 0.0f    //市净率=（P/BV）即：每股市价(P)/每股净资产(Book Value)
    Float m5Price = 0.0f
    Float m10Price = 0.0f
    Float m20Price = 0.0f
    Float m30Price = 0.0f
    Float m60Price = 0.0f
    Float m120Price = 0.0f

    static constraints = {
    }

    static mapping = {
        version(false)
        id composite: ['stockId', 'datetime']
        stockId index: 'StockDayStat_StockId_Idx'
        datetime index: 'StockDayStat_DateTime_Idx'
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof StockDayStat)) return false
        StockDayStat that = (StockDayStat) o
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
