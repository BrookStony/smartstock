import java.util.concurrent.Executors

// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// enable only when you need it
grails.resources.resourceLocatorEnabled = true

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/app/*', '/plugins/*']
grails.resources.adhoc.includes = ['/images/**', '/css/**', '/js/**', '/app/**', '/plugins/**']
grails.resources.adhoc.excludes = ['**/WEB-INF/**', '**/META-INF/**']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = ['com.smartstock.services']
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        quartz.autoStartup = false
        activiti.databaseType = 'h2'
        grails.logging.jul.usebridge = true
        grails.plugin.databasemigration.updateOnStart = false
    }
    production {
        quartz.autoStartup = true
        activiti.databaseType = 'mysql'
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
        grails.plugin.databasemigration.updateOnStart = true
    }
}

// log4j configuration
log4j.main = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

beans {
    asyncApplicationEventMulticaster {
        taskExecutor = Executors.newCachedThreadPool()
        retryScheduler = Executors.newScheduledThreadPool(5)
    }
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.active = false
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.smartstock.auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.smartstock.auth.UserRole'
grails.plugin.springsecurity.authority.className = 'com.smartstock.auth.Role'
//grails.plugin.springsecurity.securityConfigType = "Requestmap"
//grails.plugin.springsecurity.requestMap.className = 'com.smartstock.auth.Requestmap'
//grails.plugin.springsecurity.requestMap.urlField = 'url'
//grails.plugin.springsecurity.requestMap.configAttributeField = 'configAttribute'
//grails.plugin.springsecurity.requestMap.httpMethodField = 'httpMethod'
//grails.plugin.springsecurity.rejectIfNoRule = true
//grails.plugin.springsecurity.fii.rejectPublicInvocations = false
//grails.plugin.springsecurity.controllerAnnotations.staticRules = [
//        '/index':          ['permitAll'],
//        '/index.gsp':      ['permitAll'],
//        '/assets/**':      ['permitAll'],
//        '/**/app/**':      ['permitAll'],
//        '/**/js/**':       ['permitAll'],
//        '/**/css/**':      ['permitAll'],
//        '/**/images/**':   ['permitAll'],
//        '/**/favicon.ico': ['permitAll'],
//        '/'              : ['IS_AUTHENTICATED_FULLY'],
//        '/**'            : ['IS_AUTHENTICATED_FULLY']
//]
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
        '/index.gsp'            : ['permitAll'],
        '/**/app/**'            : ['permitAll'],
        '/**/js/**'             : ['permitAll'],
        '/**/css/**'            : ['permitAll'],
        '/**/images/**'         : ['permitAll'],
        '/**/favicon.ico'       : ['permitAll'],
        '/login/**'             : ['permitAll'],
        '/logout/**'            : ['permitAll'],
        '/rest/**'              : ['permitAll'],
        '/auth/**'              : ['permitAll'],
        '/user/**'              : ['ROLE_ADMIN', 'ROLE_SYSTEM_ADMIN'],
        '/users/**'             : ['ROLE_ADMIN', 'ROLE_SYSTEM_ADMIN'],
        '/role/**'              : ['ROLE_ADMIN', 'ROLE_SYSTEM_ADMIN'],
        '/roles/**'             : ['ROLE_ADMIN', 'ROLE_SYSTEM_ADMIN'],
        '/admin/**'             : ['ROLE_ADMIN', 'ROLE_SYSTEM_ADMIN'],
        '/settings/**'          : ['ROLE_ADMIN', 'ROLE_SYSTEM_ADMIN'],
        '/setting/**'           : ['ROLE_ADMIN', 'ROLE_SYSTEM_ADMIN'],
        '/'                     : ['IS_AUTHENTICATED_FULLY'],
        '/**'                   : ['IS_AUTHENTICATED_FULLY']
]
grails.plugin.springsecurity.logout.postOnly = false
