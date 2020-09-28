package com.anibalbastias.weatherlib.data.model.currentconditions

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.CODE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LOCALIZED_TEXT
import com.squareup.moshi.Json

data class RemotePressureTendency(
    @field:Json(name = LOCALIZED_TEXT) val localizedText: String,
    @field:Json(name = CODE) val code: String
)