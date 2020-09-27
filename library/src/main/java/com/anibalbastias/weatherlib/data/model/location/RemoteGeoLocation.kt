package com.anibalbastias.weatherlib.data.model.location

import com.anibalbastias.weatherlib.data.model.common.RemoteLocal
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ADMINISTRATIVE_AREA
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.COUNTRY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.DATA_SETS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ENGLISH_NAME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.GEO_POSITION
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.IS_ALIAS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.KEY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LOCALIZED_NAME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PARENT_CITY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PRIMARY_POSTAL_CODE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.RANK
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.REGION
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.SUPPLEMENTAL_ADMIN_AREAS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.TIME_ZONE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.TYPE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.VERSION
import com.squareup.moshi.Json

data class RemoteGeoLocation(
    @field:Json(name = ADMINISTRATIVE_AREA) val administrativeArea: RemoteAdministrativeArea? = null,
    @field:Json(name = PARENT_CITY) val parentCity: RemoteLocal? = null,
    @field:Json(name = LOCALIZED_NAME) val localizedName: String? = null,
    @field:Json(name = SUPPLEMENTAL_ADMIN_AREAS) val supplementalAdminAreas: List<RemoteLocal?>? = null,
    @field:Json(name = DATA_SETS) val dataSets: List<String?>? = null,
    @field:Json(name = RANK) val rank: Int? = null,
    @field:Json(name = IS_ALIAS) val isAlias: Boolean? = null,
    @field:Json(name = TYPE) val type: String? = null,
    @field:Json(name = TIME_ZONE) val timeZone: RemoteTimeZone? = null,
    @field:Json(name = VERSION) val version: Int? = null,
    @field:Json(name = PRIMARY_POSTAL_CODE) val primaryPostalCode: String? = null,
    @field:Json(name = REGION) val region: RemoteLocal? = null,
    @field:Json(name = COUNTRY) val country: RemoteLocal? = null,
    @field:Json(name = GEO_POSITION) val geoPosition: RemoteGeoPosition? = null,
    @field:Json(name = KEY) val key: String? = null,
    @field:Json(name = ENGLISH_NAME) val englishName: String? = null
)

