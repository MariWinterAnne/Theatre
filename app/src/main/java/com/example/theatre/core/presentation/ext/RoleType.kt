package com.example.theatre.core.presentation.ext

import androidx.annotation.StringRes
import com.example.theatre.R

/**
 * Role type - сопоставляет текстовый идентификатор роли с названием
 *
 * @property title - название роли
 * @property resId - строковый ресурс
 * @author Tamerlan Mamukhov
 */

sealed class RoleType(val title: String, @StringRes val resId: Int) {
    object Actor : RoleType("actors", R.string.actor)
    object Director : RoleType("director", R.string.director)
    object Musician : RoleType("musician", R.string.musician)
    object Screenwriter : RoleType("screenwriter", R.string.screenwriter)
    object Stage : RoleType("stage-theatre", R.string.stage_theatre)
    object Unknown : RoleType("", R.string.empty)
}

fun String.toRole(): Int =
    when (this) {
        RoleType.Actor.title -> RoleType.Actor.resId
        RoleType.Director.title -> RoleType.Director.resId
        RoleType.Musician.title -> RoleType.Musician.resId
        RoleType.Screenwriter.title -> RoleType.Screenwriter.resId
        RoleType.Stage.title -> RoleType.Stage.resId
        else -> RoleType.Unknown.resId
    }

/**
 * Agent type - сопоставляет текстовый идентификатор агента с названием
 *
 * @property title - тип элемента
 * @property resId - строковый ресурс
 * @author Tamerlan Mamukhov
 */

sealed class AgentType(val title: String, @StringRes val resId: Int) {
    object Person : AgentType("person", R.string.activist)
    object Organization : AgentType("organization", R.string.organization)
    object Unknown : AgentType("", R.string.empty)
}

fun String.toAgent(): Int =
    when (this) {
        AgentType.Person.title -> AgentType.Person.resId
        AgentType.Organization.title -> AgentType.Organization.resId
        else -> AgentType.Unknown.resId
    }