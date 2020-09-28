package com.anibalbastias.weatherlib.data.model.currentconditions

import com.anibalbastias.weatherlib.data.model.common.RemoteMetricType
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_12_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_18_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_24_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_3_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_6_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_9_HOURS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_HOUR
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PRECIPITATION
import com.squareup.moshi.Json

data class RemotePrecipitationSummary(
    @field:Json(name = PRECIPITATION) val precipitation: RemoteMetricType,
    @field:Json(name = PAST_HOUR) val pastHour: RemoteMetricType,
    @field:Json(name = PAST_3_HOURS) val past3Hours: RemoteMetricType,
    @field:Json(name = PAST_6_HOURS) val past6Hours: RemoteMetricType,
    @field:Json(name = PAST_9_HOURS) val past9Hours: RemoteMetricType,
    @field:Json(name = PAST_12_HOURS) val past12Hours: RemoteMetricType,
    @field:Json(name = PAST_18_HOURS) val past18Hours: RemoteMetricType,
    @field:Json(name = PAST_24_HOURS) val past24Hours: RemoteMetricType
)