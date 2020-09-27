package com.anibalbastias.weatherlib.data.retrofit.service

import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.CITY_KEY
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.N_DAYS

object Constants {

    object Endpoint {
        private const val API_VERSION = "v1"
        const val SEARCH_GEO_POSITION = "locations/$API_VERSION/cities/geoposition/search"
        const val GET_CURRENT_CONDITIONS = "currentconditions/$API_VERSION/{$CITY_KEY}"
        const val GET_N_DAYS_FORECASTS = "forecasts/$API_VERSION/daily/{$N_DAYS}/{$CITY_KEY}"
    }

    object Request {
        const val CITY_KEY = "cityKey"
        const val DETAILS = "details"
        const val QUERY = "q"
        const val N_DAYS = "nDays"
        const val ONE_DAY = "1day"
        const val FIVE_DAYS = "5day"
    }

    object Keys {
        const val UNIT_TYPE = "UnitType"
        const val VALUE = "Value"
        const val UNIT = "Unit"
        const val LOCALIZED_NAME = "LocalizedName"
        const val ID = "ID"
        const val ENGLISH_NAME = "EnglishName"
        const val COUNTRY_ID = "CountryID"
        const val LOCALIZED_TYPE = "LocalizedType"
        const val LEVEL = "Level"
        const val ENGLISH_TYPE = "EnglishType"
        const val METRIC = "Metric"
        const val IMPERIAL = "Imperial"
        const val ELEVATION = "Elevation"
        const val LATITUDE = "Latitude"
        const val LONGITUDE = "Longitude"
        const val ADMINISTRATIVE_AREA = "AdministrativeArea"
        const val PARENT_CITY = "ParentCity"
        const val SUPPLEMENTAL_ADMIN_AREAS = "SupplementalAdminAreas"
        const val DATA_SETS = "DataSets"
        const val RANK = "Rank"
        const val IS_ALIAS = "IsAlias"
        const val TYPE = "Type"
        const val TIME_ZONE = "TimeZone"
        const val VERSION = "Version"
        const val PRIMARY_POSTAL_CODE = "PrimaryPostalCode"
        const val REGION = "Region"
        const val COUNTRY = "Country"
        const val GEO_POSITION = "GeoPosition"
        const val KEY = "Key"
        const val NEXT_OFFSET_CHANGE = "NextOffsetChange"
        const val GMT_OFFSET = "GmtOffset"
        const val CODE = "Code"
        const val IS_DAY_LIGHT_SAVING = "IsDaylightSaving"
        const val NAME = "Name"
        const val DEGREES = "Degrees"
        const val LOCALIZED = "Localized"
        const val ENGLISH = "English"
        const val PRECIPITATION = "Precipitation"
        const val PAST_HOUR = "PastHour"
        const val PAST_3_HOURS = "Past3Hours"
        const val PAST_6_HOURS = "Past6Hours"
        const val PAST_9_HOURS = "Past9Hours"
        const val PAST_12_HOURS = "Past12Hours"
        const val PAST_18_HOURS = "Past18Hours"
        const val PAST_24_HOURS = "Past24Hours"
        const val SPEED = "Speed"
        const val DIRECTION = "Direction"
        const val LOCALIZED_TEXT = "LocalizedText"
        const val LOCAL_OBSERVATION_DATE_TIME = "LocalObservationDateTime"
        const val EPOCH_TIME = "EpochTime"
        const val WEATHER_TEXT = "WeatherText"
        const val WEATHER_ICON = "WeatherIcon"
        const val HAS_PRECIPITATION = "HasPrecipitation"
        const val PRECIPITATION_TYPE = "PrecipitationType"
        const val IS_DAY_TIME = "IsDayTime"
        const val TEMPERATURE = "Temperature"
        const val REAL_FEEL_TEMPERATURE = "RealFeelTemperature"
        const val REAL_FEEL_TEMPERATURE_SHADE = "RealFeelTemperatureShade"
        const val RELATIVE_HUMIDITY = "RelativeHumidity"
        const val INDOOR_RELATIVE_HUMIDITY = "IndoorRelativeHumidity"
        const val DEW_POINT = "DewPoint"
        const val WIND = "Wind"
        const val WIND_GUST = "WindGust"
        const val UV_INDEX = "UVIndex"
        const val UV_INDEX_TEXT = "UVIndexText"
        const val VISIBILITY = "Visibility"
        const val OBSTRUCTIONS_TO_VISIBILITY = "ObstructionsToVisibility"
        const val CLOUD_COVER = "CloudCover"
        const val CEILING = "Ceiling"
        const val PRESSURE = "Pressure"
        const val PRESSURE_TENDENCY = "PressureTendency"
        const val PAST_24_HOUR_TEMPERATURE_DEPARTURE = "Past24HourTemperatureDeparture"
        const val APPARENT_TEMPERATURE = "ApparentTemperature"
        const val WIND_CHILL_TEMPERATURE = "WindChillTemperature"
        const val WET_BULB_TEMPERATURE = "WetBulbTemperature"
        const val PRECIP_1_HR = "Precip1hr"
        const val PRECIPITATION_SUMMARY = "PrecipitationSummary"
        const val TEMPERATURE_SUMMARY = "TemperatureSummary"
        const val MOBILE_LINK = "MobileLink"
        const val LINK = "Link"
        const val DATE = "Date"
        const val SOURCES = "Sources"
        const val DAY = "Day"
        const val EPOCH_DATE = "EpochDate"
        const val NIGHT = "Night"
        const val HEAD_LINE = "Headline"
        const val DAILY_FORECASTS = "DailyForecasts"
        const val MINIMUM = "Minimum"
        const val MAXIMUM = "Maximum"
        const val CATEGORY = "Category"
        const val END_EPOCH_DATE = "EndEpochDate"
        const val EFFECTIVE_EPOCH_DATE = "EffectiveEpochDate"
        const val SEVERITY = "Severity"
        const val TEXT = "Text"
        const val END_DATE = "EndDate"
        const val EFFECTIVE_DATE = "EffectiveDate"
    }
}
