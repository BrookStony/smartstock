package com.smartstock.common

import com.smartstock.auth.Requestmap
import com.smartstock.auth.Role
import com.smartstock.auth.RoleMenu
import com.smartstock.auth.User
import com.smartstock.auth.UserRole
import com.smartstock.stock.Exchange
import com.smartstock.system.Menu

class InitService {

    def grailsApplication
    def locationInitService

    def init() {
        initUsers()
        locationInitService.init()
        initExchange()
    }

    def initExchange() {
        if(!Exchange.count()) {
            def shanghaiExChange = new Exchange(code: "SHSE", name: "上证", alias: "沪市", fullName: "上海证券交易所",  enName: "Shanghai Stock Exchange", setupDate: "1990-11-26", province: "上海", city: "上海")
            shanghaiExChange.location = Location.findByName("上海")
            shanghaiExChange.address = "上海浦东新区"
            shanghaiExChange.description = "上海证券交易所（Shanghai Stock Exchange）是中国大陆两所证券交易所之一，位于上海浦东新区。上海证券交易所创立于1990年11月26日，同年12月19日开始正式营业。截至2009年年底，上证所拥有870家上市公司，上市证券数1351个，股票市价总值184655.23亿元。一大批国民经济支柱企业、重点企业、基础行业企业和高新科技企业通过上市，既筹集了发展资金，又转换了经营机制。"
            shanghaiExChange.save(failOnError: true)

            def shenzhenExChange = new Exchange(code: "SZSE", name: "深证", alias: "深市", fullName: "深圳证券交易所",  enName: "Shenzhen Stock Exchange", setupDate: "1990-12-01",  province: "广东", city: "深圳")
            shenzhenExChange.location = Location.findByName("深圳")
            shenzhenExChange.address = "中国深圳深南大道2012号"
            shenzhenExChange.description = "深圳证券交易所（以下简称“深交所”）成立于1990年12月1日，是为证券集中交易提供场所和设施，组织和监督证券交易，履行国家有关法律、法规、规章、政策规定的职责，实行自律管理的法人。深交所的主要职能包括：提供证券交易的场所和设施；制定业务规则；审核证券上市申请、安排证券上市；组织、监督证券交易；对会员进行监管；对上市公司进行监管；管理和公布市场信息；中国证监会许可的其他职能。"
            shenzhenExChange.save(failOnError: true)
        }
    }

    def initUsers() {
        if(!Requestmap.count()){
//            for (String url in [
//                    '/', '/index', '/index.gsp', '/**/favicon.ico',
//                    '/**/js/**', '/**/css/**', '/**/images/**',
//                    '/login/**', '/logout/**',
//                    '/rest/**', '/receiveMessage/**', '/memberApi/**',
//                    '/chatMessageApi/**', '/accessTokenApi/**']) {
//                new Requestmap(url: url, configAttribute: 'permitAll').save()
//            }
        }
        if(!User.count()){
//            def systemRole = new Role(name: "系统管理员", authority: Role.ROLE_SYSTEM_ADMIN, description: "具有系统全部权限").save(flush: true)
//            def adminRole = new Role(name: "管理员", authority: Role.ROLE_ADMIN, description: "管理员权限").save(flush: true)
//            def userRole = new Role(name: "用户", authority: Role.ROLE_USER, description: "一般用户权限").save(flush: true)
//            def administrator = new User(username: "administrator", password: "admin", name: "Administrator", email: "administrator@example.com").save(flush: true)
//            def admin = new User(username: "admin", password: "admin", name: "Admin", email: "admin@example.com").save(flush: true)
//            def user = new User(username: "chat", password: "chat", name: "Chat", email: "chat@example.com").save(flush: true)
//            UserRole.create(administrator, systemRole, true)
//            UserRole.create(admin, adminRole, true)
//            UserRole.create(user, userRole, true)
//
//            Menu.list().each {
//                RoleMenu.create(it, systemRole)
//                RoleMenu.create(it, adminRole)
//                RoleMenu.create(it, userRole)
//            }
        }
    }
}
