package com.purpleeagle.fplpredictor.model.models.elementsummary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fixture (

    @SerialName("id"                     ) var id                   : Int?     = null,
    @SerialName("code"                   ) var code                 : Int?     = null,
    @SerialName("team_h"                 ) var teamH                : Int?     = null,
    @SerialName("team_h_score"           ) var teamHScore           : String?  = null,
    @SerialName("team_a"                 ) var teamA                : Int?     = null,
    @SerialName("team_a_score"           ) var teamAScore           : String?  = null,
    @SerialName("event"                  ) var event                : Int?     = null,
    @SerialName("finished"               ) var finished             : Boolean? = null,
    @SerialName("minutes"                ) var minutes              : Int?     = null,
    @SerialName("provisional_start_time" ) var provisionalStartTime : Boolean? = null,
    @SerialName("kickoff_time"           ) var kickoffTime          : String?  = null,
    @SerialName("event_name"             ) var eventName            : String?  = null,
    @SerialName("is_home"                ) var isHome               : Boolean? = null,
    @SerialName("difficulty"             ) var difficulty           : Int?     = null

)
