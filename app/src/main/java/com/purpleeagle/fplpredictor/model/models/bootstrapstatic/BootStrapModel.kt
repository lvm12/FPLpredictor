package com.purpleeagle.fplpredictor.model.models.bootstrapstatic


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BootStrapModel(
    @SerialName("events") val events: List<Events>,
    @SerialName("game_settings") val gameSettings: GameSettings,
    val phases: List<Phases>,
    val teams: List<Team>,
    @SerialName("total_players") val totalPlayers: Int,
    @SerialName("elements") var players: List<Player>,
    @SerialName("element_stats") val elementStats: List<ElementStats>,
    @SerialName("element_types") val elementTypes: List<ElementTypes>,
)
