package com.anibalbastias.weatherlib.data.model.common

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.IMPERIAL
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.METRIC
import com.squareup.moshi.Json

data class RemoteMetricType(
    @field:Json(name = METRIC) val metric: RemoteUnit? = null,
    @field:Json(name = IMPERIAL) val imperial: RemoteUnit? = null
)