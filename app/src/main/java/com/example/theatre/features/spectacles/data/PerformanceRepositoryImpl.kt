package com.example.theatre.features.spectacles.data

import com.example.theatre.features.spectacles.data.mappers.GetPerformanceMapper
import com.example.theatre.features.info.data.network.net.RetrofitClient
import com.example.theatre.features.spectacles.data.mappers.GetAgentMapper
import com.example.theatre.features.spectacles.data.mappers.GetRoleMapper
import com.example.theatre.features.spectacles.data.model.Location
import com.example.theatre.features.spectacles.data.model.Place
import com.example.theatre.features.spectacles.domain.model.Agent
import com.example.theatre.features.spectacles.domain.model.Performance
import com.example.theatre.features.spectacles.domain.model.Role
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository

class PerformanceRepositoryImpl(
    private val getPerformanceMapper: GetPerformanceMapper,
    private val getAgentMapper: GetAgentMapper,
    private val getRoleMapper: GetRoleMapper
) : PerformanceRepository {
    override suspend fun getPerformance(): List<Performance> =
        RetrofitClient.retrofit.getPerformance().results.map{getPerformanceMapper.getPerformance(it)}

    override suspend fun getPerformanceById(id: Int): Performance =
        RetrofitClient.retrofit.getPerformanceById(id = id)

    override suspend fun getPlaceById(id: Int): Place =
        RetrofitClient.retrofit.getPlaceById(id = id)

    override suspend fun getCityName(slug: String): Location =
        RetrofitClient.retrofit.getCityName(slug = slug)

    override suspend fun getAgent(): List<Agent> =
        RetrofitClient.retrofit.getAgent().results.map{getAgentMapper.getAgent(it)}

    override suspend fun getRole(): List<Role> =
        RetrofitClient.retrofit.getRoles().results.map{getRoleMapper.getRole(it)}
}