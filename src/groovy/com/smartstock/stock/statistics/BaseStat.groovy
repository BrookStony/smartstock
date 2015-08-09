package com.smartstock.stock.statistics

/**
 * Created by Administrator on 2015/7/3.
 */
abstract class BaseStat implements Serializable {

    Float highPrice = 0.0f //最高价
    Float lowPrice = 0.0f //最低价
    Float openPrice = 0.0f //开盘价
    Float closePrice = 0.0f //收盘价
    Float lastPrice = 0.0f //昨日收盘价
    Long volume = 0l //成交量
    Long amountOfMoney = 0l //成交金额
    Long totalShares = 0l   //总市值
    Long tradingShares = 0l   //流通市值
    Float turnoverRate = 0.0f    //Turnover Rate换手率
    Float amplitude = 0.0f //振幅
    Float changeAmount = 0.0f    //涨跌额
    Float changeRate = 0.0f    //涨跌百分比
}
