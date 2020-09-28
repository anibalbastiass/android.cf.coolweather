package com.anibalbastias.weatherlib.data.mapper

import com.anibalbastias.weatherlib.factory.GeoLocationFactory
import junit.framework.Assert.assertEquals
import org.junit.Test

class GeoPositionMapperTest {

    private val mapper = GeoPositionMapper()

    @Test
    fun `given RemoteGeoLocation, when fromRemoteToDomain, then DomainGeoLocation`() {
        val remote = GeoLocationFactory.makeRemoteGeoLocation()
        val domain = with(mapper) { remote.fromRemoteToDomain() }

        assert(remote.key != null)
        assertEquals("cityKey", remote.key, domain.cityKey)
        assertEquals("cityName", remote.englishName, domain.cityName)
        assertEquals("country", remote.country?.englishName, domain.country)
        assertEquals("parentCity", remote.parentCity?.englishName, domain.parentCity)
    }
}
