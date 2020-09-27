package com.anibalbastias.weatherlib.data.model.currentconditions

import com.anibalbastias.weatherlib.data.model.common.RemoteMetricType
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.APPARENT_TEMPERATURE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.CEILING
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.CLOUD_COVER
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.DEW_POINT
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.EPOCH_TIME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.HAS_PRECIPITATION
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.INDOOR_RELATIVE_HUMIDITY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.IS_DAY_TIME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LINK
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.LOCAL_OBSERVATION_DATE_TIME
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.MOBILE_LINK
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.OBSTRUCTIONS_TO_VISIBILITY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PAST_24_HOUR_TEMPERATURE_DEPARTURE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PRECIPITATION_SUMMARY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PRECIPITATION_TYPE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PRECIP_1_HR
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PRESSURE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.PRESSURE_TENDENCY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.REAL_FEEL_TEMPERATURE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.REAL_FEEL_TEMPERATURE_SHADE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.RELATIVE_HUMIDITY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.TEMPERATURE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.TEMPERATURE_SUMMARY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.UV_INDEX
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.UV_INDEX_TEXT
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.VISIBILITY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.WEATHER_ICON
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.WEATHER_TEXT
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.WET_BULB_TEMPERATURE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.WIND
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.WIND_CHILL_TEMPERATURE
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Keys.WIND_GUST
import com.squareup.moshi.Json

data class RemoteCurrentCondition(
    @field:Json(name = LOCAL_OBSERVATION_DATE_TIME) val localObservationDateTime: String,
    @field:Json(name = EPOCH_TIME) val epochTime: Int,
    @field:Json(name = WEATHER_TEXT) val weatherText: String,
    @field:Json(name = WEATHER_ICON) val weatherIcon: Int,
    @field:Json(name = HAS_PRECIPITATION) val hasPrecipitation: Boolean,
    @field:Json(name = PRECIPITATION_TYPE) val precipitationType: String,
    @field:Json(name = IS_DAY_TIME) val isDayTime: Boolean,
    @field:Json(name = TEMPERATURE) val temperature: RemoteMetricType,
    @field:Json(name = REAL_FEEL_TEMPERATURE) val realFeelTemperature: RemoteMetricType,
    @field:Json(name = REAL_FEEL_TEMPERATURE_SHADE) val realFeelTemperatureShade: RemoteMetricType,
    @field:Json(name = RELATIVE_HUMIDITY) val relativeHumidity: Int,
    @field:Json(name = INDOOR_RELATIVE_HUMIDITY) val indoorRelativeHumidity: Int,
    @field:Json(name = DEW_POINT) val dewPoint: RemoteMetricType,
    @field:Json(name = WIND) val wind: RemoteWind,
    @field:Json(name = WIND_GUST) val windGust: RemoteWindGust,
    @field:Json(name = UV_INDEX) val uVIndex: Int,
    @field:Json(name = UV_INDEX_TEXT) val uVIndexText: String,
    @field:Json(name = VISIBILITY) val visibility: RemoteMetricType,
    @field:Json(name = OBSTRUCTIONS_TO_VISIBILITY) val obstructionsToVisibility: String,
    @field:Json(name = CLOUD_COVER) val cloudCover: Int,
    @field:Json(name = CEILING) val ceiling: RemoteMetricType,
    @field:Json(name = PRESSURE) val pressure: RemoteMetricType,
    @field:Json(name = PRESSURE_TENDENCY) val pressureTendency: RemotePressureTendency,
    @field:Json(name = PAST_24_HOUR_TEMPERATURE_DEPARTURE) val past24HourTemperatureDeparture: RemoteMetricType,
    @field:Json(name = APPARENT_TEMPERATURE) val apparentTemperature: RemoteMetricType,
    @field:Json(name = WIND_CHILL_TEMPERATURE) val windChillTemperature: RemoteMetricType,
    @field:Json(name = WET_BULB_TEMPERATURE) val wetBulbTemperature: RemoteMetricType,
    @field:Json(name = PRECIP_1_HR) val precip1hr: RemoteMetricType,
    @field:Json(name = PRECIPITATION_SUMMARY) val precipitationSummary: RemotePrecipitationSummary,
    @field:Json(name = TEMPERATURE_SUMMARY) val temperatureSummary: RemoteTemperatureSummary,
    @field:Json(name = MOBILE_LINK) val mobileLink: String,
    @field:Json(name = LINK) val link: String
)