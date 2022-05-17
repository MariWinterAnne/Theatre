package com.example.theatre.features.info.data.mappers

import com.example.theatre.features.info.data.model.GetAgent
import com.example.theatre.features.info.domain.model.Agent

interface GetPersonMapper {
    fun getPerson(person: GetAgent): Agent
}

class GetPersonMapperImpl : GetPersonMapper {
    override fun getPerson(person: GetAgent) =
        Agent(
            person.id,
            person.title,
            person.slug,
            person.description,
            person.bodyText,
            person.agentType,
            person.images,
            person.siteUrl,
            person.isStub,
            person.participations
        )
}