package com.ryzakka.responsi1mobile50

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable@Parcelize

data class Player(
    val name: String? = null,
    val position: String? = null,
    val nationality: String? = null,
    val dateOfBirth: String? = null
) : Parcelable

@Parcelize
data class Coach(
    val name: String? = null,
    val dateOfBirth: String? = null,
    val nationality: String? = null
) : Parcelable

data class TeamResponse(
    val name: String? = null,
    val crest: String? = null,
    val venue: String? = null,
    val founded: Int? = null,
    val clubColors: String? = null,
    val coach: Coach? = null,
    val squad: List<Player>? = null
)

