package com.smartstock.stock

import com.smartstock.base.DateBase

/**
 * 行业
 */
class IndustryCategory extends DateBase {

    String name
    String description

    static constraints = {
        description nullable: true
    }
}
