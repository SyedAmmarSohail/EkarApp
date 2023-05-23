package com.example.ekar.presentation

import com.example.ekar.domain.repository.EkarRepository
import com.example.ekar.domain.usecase.VehicleDetailUsecase
import com.example.ekar.factory.vehicleDetail
import com.example.ekar.utils.*
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.lang.Exception

@OptIn(ExperimentalCoroutinesApi::class)
internal class EkarViewModelTest {

    private lateinit var ekarViewModel: EkarViewModel

    @MockK
    private lateinit var ekarRepository: EkarRepository

    private lateinit var vehicleDetailUsecase: VehicleDetailUsecase

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        MockKAnnotations.init(this, relaxed = true)
        vehicleDetailUsecase = VehicleDetailUsecase(ekarRepository)
        ekarViewModel = EkarViewModel(vehicleDetailUsecase)
    }

    @Test
    fun `fetch vehicle detail success`(): Unit = runTest {
        vehicleDetail?.let {
            val vehicleDetailResponseTest = Result.Success(vehicleDetail)
            coEvery { vehicleDetailUsecase.invoke() } returns vehicleDetailResponseTest

            ekarViewModel.onEvent(EkarEvent.OnFetchVehicleDetail(true))

            assertThat(vehicleDetailResponseTest.data).isEqualTo(ekarViewModel.state.vehicleDetail)
        }
    }

    @Test
    fun `fetch vehicle detail error`(): Unit = runTest {

        val vehicleDetailResponseTest = Result.Error(Exception("Error"))
        coEvery { vehicleDetailUsecase.invoke() } returns vehicleDetailResponseTest

        ekarViewModel.onEvent(EkarEvent.OnFetchVehicleDetail(true))

        assertThat(ekarViewModel.state.vehicleDetail).isNull()
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}