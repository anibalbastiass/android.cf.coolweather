package com.anibalbastias.weatherlib.data.model.common

import com.squareup.moshi.Json

data class RemoteForecastDay(
    @Json(name = "HasPrecipitation") val hasPrecipitation: Boolean? = null,
    @Json(name = "IconPhrase") val iconPhrase: String? = null,
    @Json(name = "Icon") val icon: Int? = null
)