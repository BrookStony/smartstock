package com.smartstock.common

import com.smartstock.type.LocationGrade
import com.smartstock.type.LocationKind
import com.smartstock.type.LocationType

class Location {

    Location parent
    String code
    String name
    String fullname
    Integer sortno
    LocationType type
    LocationGrade grade = LocationGrade.FIFTHTIER
    LocationKind kind = LocationKind.COMMON

    static constraints = {
        parent(nullable: true)
    }

    static mapping = {
        id generator: 'assigned'
        type enumType: 'ordinal'
        grade enumType: 'ordinal'
        kind enumType: 'ordinal'
    }

    static namedQueries = {
        findCity { province, city ->
            eq("type", LocationType.CITY)
            eq("name", city)
            parent {
                eq("name", province)
            }
        }
        findCentralCity { province, city ->
            eq("type", LocationType.DISTRICT)
            eq("name", city)
            parent {
                parent {
                    eq("name", province)
                }
            }
        }
    }
}
