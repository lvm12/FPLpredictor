package com.purpleeagle.fplpredictor.model.models.bootstrapstatic

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChipPlays (

    @SerialName("chip_name"  ) var chipName  : String? = null,
    @SerialName("num_played" ) var numPlayed : Int?    = null

)

@Serializable
data class TopElementInfo (

    @SerialName("id"     ) var id     : Int? = null,
    @SerialName("points" ) var points : Int? = null

)

@Serializable
data class Events (

    @SerialName("id"                        ) var id                     : Int?                 = null,
    @SerialName("name"                      ) var name                   : String?              = null,
    @SerialName("deadline_time"             ) var deadlineTime           : String?              = null,
    @SerialName("average_entry_score"       ) var averageEntryScore      : Int?                 = null,
    @SerialName("finished"                  ) var finished               : Boolean?             = null,
    @SerialName("data_checked"              ) var dataChecked            : Boolean?             = null,
    @SerialName("highest_scoring_entry"     ) var highestScoringEntry    : Int?                 = null,
    @SerialName("deadline_time_epoch"       ) var deadlineTimeEpoch      : Int?                 = null,
    @SerialName("deadline_time_game_offset" ) var deadlineTimeGameOffset : Int?                 = null,
    @SerialName("highest_score"             ) var highestScore           : Int?                 = null,
    @SerialName("is_previous"               ) var isPrevious             : Boolean?             = null,
    @SerialName("is_current"                ) var isCurrent              : Boolean?             = null,
    @SerialName("is_next"                   ) var isNext                 : Boolean?             = null,
    @SerialName("cup_leagues_created"       ) var cupLeaguesCreated      : Boolean?             = null,
    @SerialName("h2h_ko_matches_created"    ) var h2hKoMatchesCreated    : Boolean?             = null,
    @SerialName("chip_plays"                ) var chipPlays              : ArrayList<ChipPlays> = arrayListOf(),
    @SerialName("most_selected"             ) var mostSelected           : Int?                 = null,
    @SerialName("most_transferred_in"       ) var mostTransferredIn      : Int?                 = null,
    @SerialName("top_element"               ) var topElement             : Int?                 = null,
    @SerialName("top_element_info"          ) var topElementInfo         : TopElementInfo?      = TopElementInfo(),
    @SerialName("transfers_made"            ) var transfersMade          : Int?                 = null,
    @SerialName("most_captained"            ) var mostCaptained          : Int?                 = null,
    @SerialName("most_vice_captained"       ) var mostViceCaptained      : Int?                 = null

)

@Serializable
data class GameSettings (

    @SerialName("league_join_private_max"           ) var leagueJoinPrivateMax         : Int?              = null,
    @SerialName("league_join_public_max"            ) var leagueJoinPublicMax          : Int?              = null,
    @SerialName("league_max_size_public_classic"    ) var leagueMaxSizePublicClassic   : Int?              = null,
    @SerialName("league_max_size_public_h2h"        ) var leagueMaxSizePublicH2h       : Int?              = null,
    @SerialName("league_max_size_private_h2h"       ) var leagueMaxSizePrivateH2h      : Int?              = null,
    @SerialName("league_max_ko_rounds_private_h2h"  ) var leagueMaxKoRoundsPrivateH2h  : Int?              = null,
    @SerialName("league_prefix_public"              ) var leaguePrefixPublic           : String?           = null,
    @SerialName("league_points_h2h_win"             ) var leaguePointsH2hWin           : Int?              = null,
    @SerialName("league_points_h2h_lose"            ) var leaguePointsH2hLose          : Int?              = null,
    @SerialName("league_points_h2h_draw"            ) var leaguePointsH2hDraw          : Int?              = null,
    @SerialName("league_ko_first_instead_of_random" ) var leagueKoFirstInsteadOfRandom : Boolean?          = null,
    @SerialName("cup_start_event_id"                ) var cupStartEventId              : String?           = null,
    @SerialName("cup_stop_event_id"                 ) var cupStopEventId               : String?           = null,
    @SerialName("cup_qualifying_method"             ) var cupQualifyingMethod          : String?           = null,
    @SerialName("cup_type"                          ) var cupType                      : String?           = null,
    @SerialName("squad_squadplay"                   ) var squadSquadplay               : Int?              = null,
    @SerialName("squad_squadsize"                   ) var squadSquadsize               : Int?              = null,
    @SerialName("squad_team_limit"                  ) var squadTeamLimit               : Int?              = null,
    @SerialName("squad_total_spend"                 ) var squadTotalSpend              : Int?              = null,
    @SerialName("ui_currency_multiplier"            ) var uiCurrencyMultiplier         : Int?              = null,
    @SerialName("ui_use_special_shirts"             ) var uiUseSpecialShirts           : Boolean?          = null,
    @SerialName("ui_special_shirt_exclusions"       ) var uiSpecialShirtExclusions     : ArrayList<String> = arrayListOf(),
    @SerialName("stats_form_days"                   ) var statsFormDays                : Int?              = null,
    @SerialName("sys_vice_captain_enabled"          ) var sysViceCaptainEnabled        : Boolean?          = null,
    @SerialName("transfers_cap"                     ) var transfersCap                 : Int?              = null,
    @SerialName("transfers_sell_on_fee"             ) var transfersSellOnFee           : Double?           = null,
    @SerialName("league_h2h_tiebreak_stats"         ) var leagueH2hTiebreakStats       : ArrayList<String> = arrayListOf(),
    @SerialName("timezone"                          ) var timezone                     : String?           = null

)

@Serializable
data class Phases (

    @SerialName("id"          ) var id         : Int?    = null,
    @SerialName("name"        ) var name       : String? = null,
    @SerialName("start_event" ) var startEvent : Int?    = null,
    @SerialName("stop_event"  ) var stopEvent  : Int?    = null

)

@Serializable
data class ElementStats (

    @SerialName("label" ) var label : String? = null,
    @SerialName("name"  ) var name  : String? = null

)

@Serializable
data class ElementTypes (

    @SerialName("id"                   ) var id                 : Int?           = null,
    @SerialName("plural_name"          ) var pluralName         : String?        = null,
    @SerialName("plural_name_short"    ) var pluralNameShort    : String?        = null,
    @SerialName("singular_name"        ) var singularName       : String?        = null,
    @SerialName("singular_name_short"  ) var singularNameShort  : String?        = null,
    @SerialName("squad_select"         ) var squadSelect        : Int?           = null,
    @SerialName("squad_min_play"       ) var squadMinPlay       : Int?           = null,
    @SerialName("squad_max_play"       ) var squadMaxPlay       : Int?           = null,
    @SerialName("ui_shirt_specific"    ) var uiShirtSpecific    : Boolean?       = null,
    @SerialName("sub_positions_locked" ) var subPositionsLocked : ArrayList<Int> = arrayListOf(),
    @SerialName("element_count"        ) var elementCount       : Int?           = null

)
