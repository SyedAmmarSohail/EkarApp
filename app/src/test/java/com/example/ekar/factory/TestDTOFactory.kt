package com.example.ekar.factory

import com.example.ekar.data.remote.dto.VehicleDetail
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val adapter: JsonAdapter<VehicleDetail> = moshi.adapter(VehicleDetail::class.java)
val vehicleDetail: VehicleDetail? = adapter.fromJson(vehicleDetailJson)
