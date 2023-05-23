package com.example.ekar.domain.repository

import com.example.ekar.data.remote.dto.VehicleDetail
import com.example.ekar.utils.Result

interface EkarRepository {
    suspend fun fetchVehicleDetail(): Result<VehicleDetail>
}