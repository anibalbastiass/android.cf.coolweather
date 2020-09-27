package com.anibalbastias.weatherlib.data.model.location

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.ELEVATION
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LATITUDE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LONGITUDE
import com.squareup.moshi.Json

data class RemoteGeoPosition(
    @field:Json(name = ELEVATION) val elevation: RemoteElevation? = null,
    @field:Json(name = LATITUDE) val latitude: Double? = null,
    @field:Json(name = LONGITUDE) val longitude: Double? = null
)