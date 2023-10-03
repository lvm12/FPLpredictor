package com.purpleeagle.fplpredictor.model.models.fixtures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixtureApi (
    @SerialName("code"                   ) var code                 : Int?             = null,
    @SerialName("event"                  ) var event                : Int?             = null,
    @SerialName("finished"               ) var finished             : Boolean?         = null,
    @SerialName("finished_provisional"   ) var finishedProvisional  : Boolean?         = null,
    @SerialName("id"                     ) var id                   : Int?             = null,
    @SerialName("kickoff_time"           ) var kickoffTime          : String?          = null,
    @SerialName("minutes"                ) var minutes              : Int?             = null,
    @SerialName("provisional_start_time" ) var provisionalStartTime : Boolean?         = null,
    @SerialName("started"                ) var started              : Boolean?         = null,
    @SerialName("team_a"                 ) var teamA                : Int?             = null,
    @SerialName("team_h"                 ) var teamH                : Int?             = null,
    @SerialName("team_h_difficulty"      ) var teamHDifficulty      : Int?             = null,
    @SerialName("team_a_difficulty"      ) var teamADifficulty      : Int?             = null,
)