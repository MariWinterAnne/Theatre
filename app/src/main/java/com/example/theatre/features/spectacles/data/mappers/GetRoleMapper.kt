package com.example.theatre.features.spectacles.data.mappers

import com.example.theatre.features.spectacles.data.model.GetRole
import com.example.theatre.features.spectacles.domain.model.Role

interface GetRoleMapper {
    fun getRole(role: GetRole): Role
}

class GetRoleMapperImpl : GetRoleMapper {
    override fun getRole(role: GetRole) =
        Role(
            role.id,
            role.name
        )
}