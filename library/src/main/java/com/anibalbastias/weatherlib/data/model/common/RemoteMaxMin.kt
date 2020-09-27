package com.anibalbastias.weatherlib.data.model.common

import com.squareup.moshi.Json

data class RemoteMaxMin(
    @field:Json(name = "Minimum") val minimum: RemoteMetricType,
    @field:Json(name = "Maximum") val maximum: RemoteMetricType
)