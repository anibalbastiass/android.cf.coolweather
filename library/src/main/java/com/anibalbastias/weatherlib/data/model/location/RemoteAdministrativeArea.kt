package com.anibalbastias.weatherlib.data.model.location

import com.anibalbastias.weatherlib.data.model.common.RemoteLocal
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.COUNTRY_ID
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ENGLISH_NAME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ENGLISH_TYPE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ID
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LEVEL
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LOCALIZED_NAME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LOCALIZED_TYPE
import com.squareup.moshi.Json

data class RemoteAdministrativeArea(
    @field:Json(name = COUNTRY_ID) val countryId: String? = null,
    @field:Json(name = LOCALIZED_TYPE) val localizedType: String? = null,
    @field:Json(name = LEVEL) val level: Int? = null,
    @field:Json(name = ENGLISH_TYPE) val englishType: String? = null
) : RemoteLocal()