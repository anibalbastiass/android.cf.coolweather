package com.anibalbastias.weatherlib.data.model.currentconditions

import com.anibalbastias.weatherlib.data.model.common.RemoteMetricType
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.SPEED
import com.squareup.moshi.Json

data class RemoteWindGust(
    @field:Json(name = SPEED) val speed: RemoteMetricType
)