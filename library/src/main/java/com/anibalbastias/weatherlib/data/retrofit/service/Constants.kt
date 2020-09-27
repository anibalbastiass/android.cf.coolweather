package com.anibalbastias.weatherlib.data.retrofit.service

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.CITY_KEY

object Constants {

    object Endpoint {
        private const val API_VERSION = "v1"
        const val SEARCH_GEO_POSITION = "locations/$API_VERSION/cities/geoposition/search"
        const val GET_CURRENT_CONDITIONS = "currentconditions/$API_VERSION/{$CITY_KEY}"
    }

    object Request {
        const val CITY_KEY = "cityKey"
        const val DETAILS = "details"
        const val QUERY = "q"
    }

    object Keys {
        const val UNIT_TYPE = "UnitType"
        const val VALUE = "Value"
        const val UNIT = "Unit"
        const val LOCALIZED_NAME = "LocalizedName"
        const val ID = "ID"
        const val ENGLISH_NAME = "EnglishName"
        const val COUNTRY_ID = "CountryID"
        const val LOCALIZED_TYPE = "LocalizedType"
        const val LEVEL = "Level"
        const val ENGLISH_TYPE = "EnglishType"
        const val METRIC = "Metric"
        const val IMPERIAL = "Imperial"
        const val ELEVATION = "Elevation"
        const val LATITUDE = "Latitude"
        const val LONGITUDE = "Longitude"
        const val ADMINISTRATIVE_AREA = "AdministrativeArea"
        const val PARENT_CITY = "ParentCity"
        const val SUPPLEMENTAL_ADMIN_AREAS = "SupplementalAdminAreas"
        const val DATA_SETS = "DataSets"
        const val RANK = "Rank"
        const val IS_ALIAS = "IsAlias"
        const val TYPE = "Type"
        const val TIME_ZONE = "TimeZone"
        const val VERSION = "Version"
        const val PRIMARY_POSTAL_CODE = "PrimaryPostalCode"
        const val REGION = "Region"
        const val COUNTRY = "Country"
        const val GEO_POSITION = "GeoPosition"
        const val KEY = "Key"
        const val NEXT_OFFSET_CHANGE = "NextOffsetChange"
        const val GMT_OFFSET = "GmtOffset"
        const val CODE = "Code"
        const val IS_DAY_LIGHT_SAVING = "IsDaylightSaving"
        const val NAME = "Name"
    }
}