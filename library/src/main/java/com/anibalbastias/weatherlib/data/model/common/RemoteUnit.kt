package com.anibalbastias.weatherlib.data.model.common

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.UNIT
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.UNIT_TYPE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.VALUE
import com.squareup.moshi.Json

data class RemoteUnit(
    @field:Json(name = UNIT_TYPE) val unitType: Int? = null,
    @field:Json(name = VALUE) val value: Double? = null,
    @field:Json(name = UNIT) val unit: String? = null
)