package com.example.ekar.data.remote

import com.example.ekar.data.remote.dto.VehicleDetail
import retrofit2.Response
import retrofit2.http.GET

interface EkarApi {

    @GET("specs?vin=JTDZN3EU0E3298500")
    suspend fun fetchVehicleDetail(
    ): Response<VehicleDetail>

    companion object {
        const val BASE_URL = "https://api.carsxe.com/"
    }
}