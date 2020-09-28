package com.anibalbastias.weatherlib.data.extension

import android.os.Build
import androidx.annotation.RequiresApi
import com.anibalbastias.weatherlib.BuildConfig
import com.anibalbastias.weatherlib.data.model.common.RemoteUnit
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.util.*

object DataExtension {

    private const val DD_MM_YYYY_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private const val MMM_DD_YYYY_FORMAT = "MMM dd, yyyy"

    fun String.formatDate(): String {
        var formattedDate = ""
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                var format = SimpleDateFormat(DD_MM_YYYY_FORMAT, Locale.ENGLISH)
                format.timeZone = TimeZone.getTimeZone("UTC")
                var newDate: Date? = null
                try {
                    newDate = format.parse(this)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }

                format = SimpleDateFormat(MMM_DD_YYYY_FORMAT, Locale.ENGLISH)
                format.timeZone = TimeZone.getDefault()

                formattedDate = format.format(newDate)
            } catch (e: DateTimeException) {
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return formattedDate
    }

    fun getUrlIcon(weatherIcon: Int): String =
        BuildConfig.GRADLE_ICON_BASE_URL + weatherIcon.toString().padStart(2, '0') + "-s.png"

    fun RemoteUnit?.getImperialFormat(): String = "${this?.value} ${this?.unit}"
}