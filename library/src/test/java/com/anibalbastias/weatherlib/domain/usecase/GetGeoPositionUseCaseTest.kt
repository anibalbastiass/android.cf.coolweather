package com.anibalbastias.weatherlib.domain.usecase

import com.anibalbastias.testutils.foundation.RandomFactory
import com.anibalbastias.weatherlib.data.repository.WeatherRepositoryImpl
import com.anibalbastias.weatherlib.factory.ForecastFactory
import com.anibalbastias.weatherlib.factory.GeoLocationFactory
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetGeoPositionUseCaseTest {
    @MockK
    internal lateinit var mockRemoteRepository: WeatherRepositoryImpl

    private lateinit var cut: GetGeoPositionUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetGeoPositionUseCase(mockRemoteRepository)
    }

    @Test
    fun `return DomainGeoLocation`() {
        // given
        val latitude = RandomFactory.generateDouble()
        val longitude = RandomFactory.generateDouble()
        val query = "$latitude,$longitude"
        val domain = GeoLocationFactory.makeDomainGeoLocation()

        coEvery {
            mockRemoteRepository.getGeoPosition(query)
        } returns domain

        // when
        val result = runBlocking { cut.execute(query) }

        // then
        result shouldBeEqualTo domain
    }
}