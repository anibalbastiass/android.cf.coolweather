package com.anibalbastias.weatherlib.data.model.currentconditions

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.DEGREES
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ENGLISH
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LOCALIZED
import com.squareup.moshi.Json

data class RemoteDirection(
    @field:Json(name = DEGREES) val degrees: Int,
    @field:Json(name = LOCALIZED) val localized: String,
    @field:Json(name = ENGLISH) val english: String
)