package com.smartstock.stock.statistics

/**
 * Created by Administrator on 2015/7/3.
 */
abstract class BaseMainStat implements Serializable {

    Long volume = 0l //成交量
    Long amountOfMoney = 0l //成交金额
    Float turnoverRate = 0.0f    //Turnover Rate换手率
    Float changeRate = 0.0f    //涨跌百分比
    Long mainBuyVolume = 0l  //主力净买额
    Long mainBuyAmount = 0l  //主力净买额
    Long retailBuyVolume = 0l  //散户净买额
    Long retailBuyAmount = 0l  //散户净买额

    //主力资金流向
    Long oneDayCashFlow = 0l //1日资金流向
    Long threeDaysCashFlow = 0l //3日资金流向
    Long fiveDaysCashFlow = 0l //5日资金流向
    Long tenDaysCashFlow = 0l //10日资金流向

    //成交分布
    Float mainBuy = 0.0f       //主力买入
    Float mainSell = 0.0f     //主力卖出
    Float retailBuy = 0.0f   //散户买入
    Float retailSell = 0.0f   //散户卖出

    Float mainRatio = 0.0f   //主力控盘率

    //筹码分布
    Float profitRatio = 0.0f   //获利盘比率
    Float hungUpRatio = 0.0f   //套牢盘比率

    //主力买入成本
    Float mainBuyPrice = 0.0f   //今日买入成本
    Float mainBuyPrice20 = 0.0f   //20日买入成本
    Float mainBuyPrice60 = 0.0f   //60日买入成本
    //主力卖出成本
    Float mainSellPrice = 0.0f   //今日卖出成本
    Float mainSellPrice20 = 0.0f   //20日卖出成本
    Float mainSellPrice60 = 0.0f   //60日卖出成本
}
