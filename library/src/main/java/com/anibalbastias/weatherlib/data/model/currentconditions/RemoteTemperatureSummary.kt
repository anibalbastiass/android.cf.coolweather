package com.anibalbastias.weatherlib.data.model.currentconditions

import com.anibalbastias.weatherlib.data.model.common.RemoteMaxMin
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_12_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_24_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_6_HOURS
import com.squareup.moshi.Json

data class RemoteTemperatureSummary(
    @field:Json(name = PAST_6_HOURS) val past6HourRange: RemoteMaxMin,
    @field:Json(name = PAST_12_HOURS) val past12HourRange: RemoteMaxMin,
    @field:Json(name = PAST_24_HOURS) val past24HourRange: RemoteMaxMin
)