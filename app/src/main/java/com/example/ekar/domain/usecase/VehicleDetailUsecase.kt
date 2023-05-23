package com.example.ekar.domain.usecase

import com.example.ekar.data.remote.dto.VehicleDetail
import com.example.ekar.domain.repository.EkarRepository
import com.example.ekar.utils.Result
import javax.inject.Inject

class VehicleDetailUsecase @Inject constructor(
    private val repository: EkarRepository
) {

    suspend operator fun invoke(): Result<VehicleDetail> {
        return repository.fetchVehicleDetail()
    }
}