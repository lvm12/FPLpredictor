package com.purpleeagle.fplpredictor.model.models.bootstrapstatic

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Team(
    val code: Int?,
    val draw: Int?,
    val form: Float?,
    val id: Int?,
    val loss: Int?,
    val name: String?,
    val played: Int?,
    val points: Int?,
    val position: Int?,
    @SerialName("short_name") val shortName: String?,
    val strength: Int?,
    @SerialName("team_division") val teamDivision: String?,
    val win: Int?,
    val unavailable: Boolean?,
    @SerialName("strength_overall_home") val strengthOverallHome: Int?,
    @SerialName("strength_attack_home") val strengthAttackHome: Int?,
    @SerialName("strength_defence_home") val strengthDefenceHome: Int?,
    @SerialName("strength_overall_away") val strengthOverallAway: Int?,
    @SerialName("strength_attack_away") val strengthAttackAway: Int?,
    @SerialName("strength_defence_away") val strengthDefenceAway: Int?,
    @SerialName("pulse_id") val pulseId: Int
)
