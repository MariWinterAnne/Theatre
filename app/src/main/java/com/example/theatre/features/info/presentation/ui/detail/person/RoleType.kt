package com.example.theatre.features.info.presentation.ui.detail.person

import androidx.annotation.StringRes
import com.example.theatre.R

sealed class RoleType(val title: String,@StringRes val resId: Int) {
    object Actor: RoleType("actors", R.string.actor)
    object Director: RoleType("director", R.string.actor)
    object Musician: RoleType("musician", R.string.actor)
    object Screenwriter: RoleType("screenwriter", R.string.actor)
    object Stage: RoleType("stage-theatre", R.string.actor)
    object Unknown: RoleType("", -1)
}
