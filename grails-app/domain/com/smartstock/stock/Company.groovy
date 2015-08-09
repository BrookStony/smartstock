package com.smartstock.stock

import com.smartstock.base.DateBase
import com.smartstock.common.Location

/**
 * 公司信息
 */
class Company extends DateBase {

    String name
    String fullName
    String enName
    IndustryCategory category
    String province
    String city
    String address
    Location location

    String foundDate    //成立日期
    Integer sameCompanies   //同行业公司数
    Long registeredCapital  //注册资本
    Integer employees   //员工数量
    String businessScope    //经营范围
    String description  //公司介绍

    static constraints = {
        name(blank: false, unique: true)
        fullName nullable: true
        enName nullable: true
        category nullable: true
        province nullable: true
        city nullable: true
        address nullable: true
        location nullable: true
        foundDate nullable: true
        sameCompanies nullable: true
        registeredCapital nullable: true
        employees nullable: true
        businessScope nullable: true
        description nullable: true
    }

    static mapping = {
        businessScope length: 4000
        description length: 1000
    }
}
