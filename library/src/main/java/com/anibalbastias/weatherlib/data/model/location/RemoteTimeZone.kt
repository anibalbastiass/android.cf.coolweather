package com.anibalbastias.weatherlib.data.model.location

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.CODE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.GMT_OFFSET
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.IS_DAY_LIGHT_SAVING
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.NAME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.NEXT_OFFSET_CHANGE
import com.squareup.moshi.Json

data class RemoteTimeZone(
    @field:Json(name = NEXT_OFFSET_CHANGE) val nextOffsetChange: String? = null,
    @field:Json(name = GMT_OFFSET) val gmtOffset: Double? = null,
    @field:Json(name = CODE) val code: String? = null,
    @field:Json(name = IS_DAY_LIGHT_SAVING) val isDaylightSaving: Boolean? = null,
    @field:Json(name = NAME) val name: String? = null
)