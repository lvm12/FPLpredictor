package com.purpleeagle.fplpredictor.model.models.elementsummary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoryPast (

    @SerialName("season_name"                ) var seasonName               : String? = null,
    @SerialName("element_code"               ) var elementCode              : Int?    = null,
    @SerialName("start_cost"                 ) var startCost                : Int?    = null,
    @SerialName("end_cost"                   ) var endCost                  : Int?    = null,
    @SerialName("total_points"               ) var totalPoints              : Int?    = null,
    @SerialName("minutes"                    ) var minutes                  : Int?    = null,
    @SerialName("goals_scored"               ) var goalsScored              : Int?    = null,
    @SerialName("assists"                    ) var assists                  : Int?    = null,
    @SerialName("clean_sheets"               ) var cleanSheets              : Int?    = null,
    @SerialName("goals_conceded"             ) var goalsConceded            : Int?    = null,
    @SerialName("own_goals"                  ) var ownGoals                 : Int?    = null,
    @SerialName("penalties_saved"            ) var penaltiesSaved           : Int?    = null,
    @SerialName("penalties_missed"           ) var penaltiesMissed          : Int?    = null,
    @SerialName("yellow_cards"               ) var yellowCards              : Int?    = null,
    @SerialName("red_cards"                  ) var redCards                 : Int?    = null,
    @SerialName("saves"                      ) var saves                    : Int?    = null,
    @SerialName("bonus"                      ) var bonus                    : Int?    = null,
    @SerialName("bps"                        ) var bps                      : Int?    = null,
    @SerialName("influence"                  ) var influence                : String? = null,
    @SerialName("creativity"                 ) var creativity               : String? = null,
    @SerialName("threat"                     ) var threat                   : String? = null,
    @SerialName("ict_index"                  ) var ictIndex                 : String? = null,
    @SerialName("starts"                     ) var starts                   : Int?    = null,
    @SerialName("expected_goals"             ) var expectedGoals            : String? = null,
    @SerialName("expected_assists"           ) var expectedAssists          : String? = null,
    @SerialName("expected_goal_involvements" ) var expectedGoalInvolvements : String? = null,
    @SerialName("expected_goals_conceded"    ) var expectedGoalsConceded    : String? = null

)
