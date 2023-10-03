package com.purpleeagle.fplpredictor.model.models.elementsummary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class History (

    @SerialName("element"                    ) var element                  : Int?     = null,
    @SerialName("fixture"                    ) var fixture                  : Int?     = null,
    @SerialName("opponent_team"              ) var opponentTeam             : Int?     = null,
    @SerialName("total_points"               ) var totalPoints              : Int?     = null,
    @SerialName("was_home"                   ) var wasHome                  : Boolean? = null,
    @SerialName("kickoff_time"               ) var kickoffTime              : String?  = null,
    @SerialName("team_h_score"               ) var teamHScore               : Int?     = null,
    @SerialName("team_a_score"               ) var teamAScore               : Int?     = null,
    @SerialName("round"                      ) var round                    : Int?     = null,
    @SerialName("minutes"                    ) var minutes                  : Int?     = null,
    @SerialName("goals_scored"               ) var goalsScored              : Int?     = null,
    @SerialName("assists"                    ) var assists                  : Int?     = null,
    @SerialName("clean_sheets"               ) var cleanSheets              : Int?     = null,
    @SerialName("goals_conceded"             ) var goalsConceded            : Int?     = null,
    @SerialName("own_goals"                  ) var ownGoals                 : Int?     = null,
    @SerialName("penalties_saved"            ) var penaltiesSaved           : Int?     = null,
    @SerialName("penalties_missed"           ) var penaltiesMissed          : Int?     = null,
    @SerialName("yellow_cards"               ) var yellowCards              : Int?     = null,
    @SerialName("red_cards"                  ) var redCards                 : Int?     = null,
    @SerialName("saves"                      ) var saves                    : Int?     = null,
    @SerialName("bonus"                      ) var bonus                    : Int?     = null,
    @SerialName("bps"                        ) var bps                      : Int?     = null,
    @SerialName("influence"                  ) var influence                : String?  = null,
    @SerialName("creativity"                 ) var creativity               : String?  = null,
    @SerialName("threat"                     ) var threat                   : String?  = null,
    @SerialName("ict_index"                  ) var ictIndex                 : String?  = null,
    @SerialName("starts"                     ) var starts                   : Int?     = null,
    @SerialName("expected_goals"             ) var expectedGoals            : String?  = null,
    @SerialName("expected_assists"           ) var expectedAssists          : String?  = null,
    @SerialName("expected_goal_involvements" ) var expectedGoalInvolvements : String?  = null,
    @SerialName("expected_goals_conceded"    ) var expectedGoalsConceded    : String?  = null,
    @SerialName("value"                      ) var value                    : Int?     = null,
    @SerialName("transfers_balance"          ) var transfersBalance         : Int?     = null,
    @SerialName("selected"                   ) var selected                 : Int?     = null,
    @SerialName("transfers_in"               ) var transfersIn              : Int?     = null,
    @SerialName("transfers_out"              ) var transfersOut             : Int?     = null

)
