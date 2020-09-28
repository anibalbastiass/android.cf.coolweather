package com.anibalbastias.weatherlib.domain.usecase

import com.anibalbastias.testutils.foundation.RandomFactory
import com.anibalbastias.weatherlib.data.repository.WeatherRepositoryImpl
import com.anibalbastias.weatherlib.factory.ForecastFactory
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
class Get1DayDailyForecastsUseCaseTest {

    @MockK
    internal lateinit var mockRemoteRepository: WeatherRepositoryImpl

    private lateinit var cut: Get1DayDailyForecastsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = Get1DayDailyForecastsUseCase(mockRemoteRepository)
    }

    @Test
    fun `return DomainForecast`() {
        // given
        val cityKey = "${RandomFactory.generateInt()}"
        val domain = ForecastFactory.makeDomainForecast()

        coEvery {
            mockRemoteRepository.get1DayDailyForecasts(cityKey)
        } returns domain

        // when
        val result = runBlocking { cut.execute(cityKey) }

        // then
        result shouldBeEqualTo domain
    }
}
