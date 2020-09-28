package com.anibalbastias.weatherlib.data.model.common

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ENGLISH_NAME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ID
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LOCALIZED_NAME
import com.squareup.moshi.Json

open class RemoteLocal(
    @field:Json(name = LOCALIZED_NAME) val localizedName: String? = null,
    @field:Json(name = ID) val id: String? = null,
    @field:Json(name = ENGLISH_NAME) val englishName: String? = null
)