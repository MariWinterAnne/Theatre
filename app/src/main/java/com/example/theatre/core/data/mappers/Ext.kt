package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.AgentModel
import com.example.theatre.core.data.model.AgentParticipationsItemModel
import com.example.theatre.core.data.model.AgentParticipationsModel
import com.example.theatre.core.data.model.PerformanceModel
import com.example.theatre.core.data.model.PerformanceParticipantsModel
import com.example.theatre.core.data.model.PerformancePlaceLocationModel
import com.example.theatre.core.data.model.PerformancePlaceModel

/**
 * Проводит дополнительные преобразования
 * Например, конвертирует список из data model в список domain model
 *
 * @author Marianna Sabanchieva
 */

fun PerformanceModel.toListPerformanceDates() =
    dates.map { it.toPerformanceDates() }

fun PerformanceModel.toListPerformanceImages() =
    images.map { it.toImages() }

fun PerformanceModel.toListPerformanceParticipants() =
    participants.map { it.toPerformanceParticipants() }

fun AgentModel.toListAgentImages() =
    images.map { it.toImages() }

fun AgentModel.toListAgentParticipations() =
    participations.map { it.toAgentParticipations() }

fun PerformanceModel.toPerformancePlaceLocation() =
    location?.toPerformancePlaceLocation()

fun PerformanceModel.toPerformancePlace() =
    place?.toPerformancePlace()

fun PerformancePlaceModel.toPerformancePlaceCoordinates() =
    performancePlaceCoordinates?.toPerformancePlaceCoordinates()

fun PerformancePlaceLocationModel.toPerformancePlaceCoordinates() =
    performancePlaceCoordinates?.toPerformancePlaceCoordinates()

fun PerformanceParticipantsModel.toAgent() =
    agentModel?.toAgent()

fun PerformanceParticipantsModel.toAgentRole() =
    role?.toAgentRole()

fun AgentParticipationsModel.toAgentParticipationsItem() =
    agentParticipationsItem?.toAgentParticipationsItem()

fun AgentParticipationsModel.toAgentRole() =
    role?.toAgentRole()

fun AgentParticipationsItemModel.toImages() =
    firstImage?.toImages()

fun AgentParticipationsItemModel.toPerformancePlace() =
    performancePlace?.toPerformancePlace()