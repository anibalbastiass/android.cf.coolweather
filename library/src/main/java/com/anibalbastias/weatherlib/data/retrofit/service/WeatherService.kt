package com.anibalbastias.weatherlib.data.retrofit.service

import com.anibalbastias.weatherlib.data.model.currentconditions.RemoteCurrentCondition
import com.anibalbastias.weatherlib.data.model.forecast.RemoteForecast
import com.anibalbastias.weatherlib.data.model.location.RemoteGeoLocation
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Endpoint.GET_CURRENT_CONDITIONS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Endpoint.GET_N_DAYS_FORECASTS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Endpoint.SEARCH_GEO_POSITION
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.CITY_KEY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.DETAILS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.N_DAYS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.QUERY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET(SEARCH_GEO_POSITION)
    suspend fun getGeoPosition(
        @Query(QUERY) query: String
    ): RemoteGeoLocation?

    @GET(GET_CURRENT_CONDITIONS)
    suspend fun getCurrentConditions(
        @Path(CITY_KEY) cityKey: String,
        @Query(DETAILS) details: Boolean
    ): List<RemoteCurrentCondition>?

    @GET(GET_N_DAYS_FORECASTS)
    suspend fun getNDayDailyForecasts(
        @Path(N_DAYS) nDays: String,
        @Path(CITY_KEY) cityKey: String,
        @Query(DETAILS) details: Boolean
    ): RemoteForecast?
}