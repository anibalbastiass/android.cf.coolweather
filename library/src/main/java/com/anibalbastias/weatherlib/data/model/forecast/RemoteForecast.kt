package com.anibalbastias.weatherlib.data.model.forecast

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.DAILY_FORECASTS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.HEAD_LINE
import com.squareup.moshi.Json

data class RemoteForecast(
    @Json(name = HEAD_LINE) val headline: RemoteForecastHeadline? = null,
    @Json(name = DAILY_FORECASTS) val dailyForecasts: List<RemoteDailyForecastsItem?>? = null
)
