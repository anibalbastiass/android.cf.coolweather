package com.anibalbastias.weatherlib.data.model.common

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.MAXIMUM
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.MINIMUM
import com.squareup.moshi.Json

data class RemoteMaxMin(
    @field:Json(name = MINIMUM) val minimum: RemoteMetricType,
    @field:Json(name = MAXIMUM) val maximum: RemoteMetricType
)