package com.anibalbastias.weatherlib.data.model.forecast

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.CATEGORY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.EFFECTIVE_DATE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.EFFECTIVE_EPOCH_DATE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.END_DATE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.END_EPOCH_DATE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LINK
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.MOBILE_LINK
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.SEVERITY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.TEXT
import com.squareup.moshi.Json

data class RemoteForecastHeadline(
    @Json(name = CATEGORY) val category: String? = null,
    @Json(name = END_EPOCH_DATE) val endEpochDate: Int? = null,
    @Json(name = EFFECTIVE_EPOCH_DATE) val effectiveEpochDate: Int? = null,
    @Json(name = SEVERITY) val severity: Int? = null,
    @Json(name = TEXT) val text: String? = null,
    @Json(name = END_DATE) val endDate: String? = null,
    @Json(name = LINK) val link: String? = null,
    @Json(name = EFFECTIVE_DATE) val effectiveDate: String? = null,
    @Json(name = MOBILE_LINK) val mobileLink: String? = null
)