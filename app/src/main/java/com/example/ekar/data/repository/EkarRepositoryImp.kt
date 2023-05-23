package com.example.ekar.data.repository

import com.example.ekar.data.remote.EkarApi
import com.example.ekar.data.remote.dto.VehicleDetail
import com.example.ekar.domain.repository.EkarRepository
import com.example.ekar.utils.Result

class EkarRepositoryImp(
    private val api: EkarApi
) : EkarRepository {

    override suspend fun fetchVehicleDetail(): Result<VehicleDetail> {
        return try {
            val response = api.fetchVehicleDetail()
            if (response.isSuccessful) {
                val response = response.body() as VehicleDetail
                Result.Success(response)
            } else {
                Result.Error(Exception("Service Failed"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }
    }
}