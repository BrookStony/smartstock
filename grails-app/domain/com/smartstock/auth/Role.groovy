package com.smartstock.auth

import com.smartstock.base.DateBase
import com.smartstock.system.Menu

class Role extends DateBase {
    final static String ROLE_SYSTEM_ADMIN = 'ROLE_SYSTEM_ADMIN'
    final static String ROLE_ADMIN = 'ROLE_ADMIN'
    final static String ROLE_USER = 'ROLE_USER'

    String authority
    String name
    String description

    static mapping = {
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
        description nullable: true
    }

    Set<Menu> getMenus() {
        RoleMenu.findAllByrole(this).collect { it.menu } as Set
    }
}
