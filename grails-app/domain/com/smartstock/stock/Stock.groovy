package com.smartstock.stock

import com.smartstock.base.DateBase
import com.smartstock.common.Location
import com.smartstock.status.StockStatus

class Stock extends DateBase {

    String code
    String name
    Company company
    Exchange exchange
    Category category
    String province
    String city
    Location location

    String listTime //上市时间
    Float listPrice //发行价
    Long totalCapital   //总股本
    Long tradingShares   //流通A股
    Float eps   //Earning Per Share每股收益
    Float naps  //Net assets per share 每股净资产
    Float cfps  //Cash Flow Per Share 每股现金流
    Float prfps //public reserve funds Per Share 每股公积金
    Float roe   //ROE(Rate of Return on Common Stockholders’ Equity)每股资产收益率
    Float npgr  //Net profit growth rate净利润增长率
    Float ndpps //Non distribution profit per share每股未分配利润
    Float mrgr  //Main revenue growth rate主营收入增长率

    StockStatus status = StockStatus.OPEN

    static constraints = {
        name(blank: false, unique: true)
        company nullable: true
        exchange nullable: true
        category nullable: true
        province nullable: true
        city nullable: true
        listTime nullable: true
        listPrice nullable: true
        totalCapital nullable: true
        tradingShares nullable: true
        eps nullable: true
        naps nullable: true
        cfps nullable: true
        prfps nullable: true
        roe nullable: true
        npgr nullable: true
        ndpps nullable: true
        mrgr nullable: true
    }
}
