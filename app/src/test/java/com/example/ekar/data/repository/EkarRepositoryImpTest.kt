package com.example.ekar.data.repository

import com.example.ekar.data.remote.EkarApi
import com.example.ekar.factory.vehicleDetail
import com.example.ekar.utils.succeeded
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.io.IOException

internal class EkarRepositoryImpTest {

    private lateinit var repository: EkarRepositoryImp

    @MockK
    private lateinit var ekarApi: EkarApi

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        repository = EkarRepositoryImp(
            api = ekarApi
        )
    }

    @Test
    fun `fetch vehicle detail, return success`(): Unit = runBlocking {
        coEvery { ekarApi.fetchVehicleDetail() } returns Response.success(
            vehicleDetail
        )

        val result = repository.fetchVehicleDetail()

        assertThat(result.succeeded()).isTrue()
    }

    @Test
    fun `fetch vehicle detail, return error`(): Unit = runBlocking {
        coEvery { ekarApi.fetchVehicleDetail() } returns Response.error(
            400,
            responseBody()
        )

        val result = repository.fetchVehicleDetail()

        assertThat(!result.succeeded()).isTrue()
    }

    @Test
    fun `fetch vehicle detail, return exception`(): Unit = runBlocking {
        coEvery { ekarApi.fetchVehicleDetail() } throws IOException()

        val result = repository.fetchVehicleDetail()

        assertThat(!result.succeeded()).isTrue()
    }

    private fun responseBody() =
        ResponseBody.create("application/json".toMediaTypeOrNull(), "")

    @After
    fun tearDown() {
        unmockkAll()
    }
}