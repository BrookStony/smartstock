package com.smartstock.system

import com.smartstock.base.DateBase
import org.apache.commons.lang.builder.HashCodeBuilder

class Menu extends DateBase {

    Menu parent
    String code
    String name
    String url
    String image
    String cssicon
    Integer level
    Integer sortno
    Boolean enable = true

    static constraints = {
        parent(nullable: true)
        url(nullable: true)
        image(nullable: true)
        cssicon(nullable: true)
    }

//    boolean equals(other) {
//        if (!(other instanceof Menu)) {
//            return false
//        }
//
//        other.id == id
//    }
//
//    int hashCode() {
//        def builder = new HashCodeBuilder()
//        builder.append(id)
//        builder.toHashCode()
//    }
}
