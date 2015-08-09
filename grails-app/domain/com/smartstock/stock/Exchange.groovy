package com.smartstock.stock

import com.smartstock.base.DateBase
import com.smartstock.common.Location

/**
 * 交易所
 */
class Exchange extends DateBase {

    String code
    String name
    String alias
    String fullName
    String enName
    Location location
    String province
    String city
    String address
    String setupDate
    String description

    static constraints = {
        name(blank: false, unique: true)
        alias nullable: true
        fullName nullable: true
        enName nullable: true
        location nullable: true
        province nullable: true
        city nullable: true
        address nullable: true
        setupDate nullable: true
        description nullable: true
    }

    static mapping = {
        description lazy: true, length: 4000
    }
}
