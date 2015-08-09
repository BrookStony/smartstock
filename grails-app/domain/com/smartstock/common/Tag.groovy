package com.smartstock.common

class Tag {
    String label
    String description

    static constraints = {
        label(blank: false, unique: true)
        description nullable: true
    }
}
