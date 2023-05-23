package com.example.ekar.domain.usecase

import com.example.ekar.domain.repository.EkarRepository
import com.example.ekar.factory.vehicleDetail
import com.example.ekar.utils.Result
import com.example.ekar.utils.succeeded
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test


internal class VehicleDetailUsecaseTest {

    @MockK
    private lateinit var ekarRepository: EkarRepository
    private lateinit var vehicleDetailUsecase: VehicleDetailUsecase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        vehicleDetailUsecase = VehicleDetailUsecase(ekarRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `fetch vehicle detail, success`(): Unit = runTest {
        vehicleDetail?.let {
            val result = Result.Success(
                it
            )
            coEvery { ekarRepository.fetchVehicleDetail() } returns result

            val response = vehicleDetailUsecase.invoke()

            Truth.assertThat(response).isEqualTo(result)
        }

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `fetch vehicle detail, error`(): Unit = runTest {
        val result = Result.Error(Exception("Error"))
        coEvery { ekarRepository.fetchVehicleDetail() } returns result

        val response = vehicleDetailUsecase.invoke()

        Truth.assertThat(response.succeeded()).isFalse()

    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}