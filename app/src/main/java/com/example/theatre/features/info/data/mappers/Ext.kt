package com.example.theatre.features.info.data.mappers

import com.example.theatre.features.info.data.model.AgentModel
import com.example.theatre.features.info.data.model.AgentPerformanceParticipationsModel
import com.example.theatre.features.info.data.model.TheatreModel

/**
 * Проводит дополнительные преобразования
 * Например, конвертирует список из data model в список domain model
 *
 * @author Marianna Sabanchieva
 */

fun AgentModel.toListAgentPerformanceParticipationsModel() =
    participations?.map { it.toAgentPerformanceParticipations() }

fun AgentModel.toListImage() =
    images?.map { it.toImages() }

fun TheatreModel.toListImage() =
    images?.map { it.toImages() }

fun AgentPerformanceParticipationsModel.toAgentRoleTitle() =
    role?.toAgentRoleTitle()

fun AgentPerformanceParticipationsModel.toAgentParticipationTitle() =
    item?.toAgentParticipationTitle()

fun TheatreModel.toTheatreCoordinates() =
    coords?.toTheatreCoordinates()