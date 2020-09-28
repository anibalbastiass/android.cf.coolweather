package com.anibalbastias.weatherlib.data.model.forecast

import com.anibalbastias.weatherlib.data.model.common.RemoteForecastDay
import com.anibalbastias.weatherlib.data.model.common.RemoteMaxMin
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.DATE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.DAY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.EPOCH_DATE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LINK
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.MOBILE_LINK
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.NIGHT
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.SOURCES
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.TEMPERATURE
import com.squareup.moshi.Json

data class RemoteDailyForecastsItem(
    @Json(name = TEMPERATURE) val temperature: RemoteMaxMin? = null,
    @Json(name = NIGHT) val night: RemoteForecastDay? = null,
    @Json(name = EPOCH_DATE) val epochDate: Int? = null,
    @Json(name = DAY) val day: RemoteForecastDay? = null,
    @Json(name = SOURCES) val sources: List<String?>? = null,
    @Json(name = DATE) val date: String? = null,
    @Json(name = LINK) val link: String? = null,
    @Json(name = MOBILE_LINK) val mobileLink: String? = null
)