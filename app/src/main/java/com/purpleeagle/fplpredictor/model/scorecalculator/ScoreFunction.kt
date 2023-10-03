package com.purpleeagle.fplpredictor.model.scorecalculator

import android.util.Log
import com.purpleeagle.fplpredictor.model.functions.logStacktrace
import com.purpleeagle.fplpredictor.model.functions.toIntOr
import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.BootStrapModel
import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.Events
import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.Player
import com.purpleeagle.fplpredictor.model.models.elementsummary.ElementSummary
import com.purpleeagle.fplpredictor.model.models.elementsummary.Fixture
import com.purpleeagle.fplpredictor.model.models.enums.DoubleType
import com.purpleeagle.fplpredictor.model.models.fixtures.FixtureApi

fun calculate(
    bootStrapModel: BootStrapModel,
    element: Player,
    elementSummary: ElementSummary,
    fixtures: List<FixtureApi>
): Float{
    Log.d("Calculate","Started calculation")
    val currentGameweek: MutableList<Events>
    var last4GameWeeks: List<FixtureApi> = emptyList()
    val next3GameWeeks: List<Fixture>
    val homeOrAway: MutableMap<Int, DoubleType<Boolean, FixtureApi>> = mutableMapOf()
    var last4difficulties: Int = 12
    var nextDifficulty: Float = 0f
    Log.d("Calculate${element.webName}", "Calculating ${element.webName}")
    try {
        currentGameweek = bootStrapModel.events.filter { it.isCurrent == true }.toMutableList()
        if (currentGameweek[0].finished == false) {
            currentGameweek[0] =
                bootStrapModel.events.filter { it.id == currentGameweek[0].id!! - 1 }[0]
        }
        Log.d("Calculate${element.webName}", "Got current gameweek")
        try {
            last4GameWeeks = fixtures.filter {
                (it.event.toIntOr(100) < currentGameweek[0].id.toIntOr(0) && it.event.toIntOr(0) > currentGameweek[0].id.toIntOr(100) - 5) && ((element.team == it.teamA) || (element.team == it.teamH))
            }
            Log.d("Calculate${element.webName}","Size of last gameweeks is ${last4GameWeeks.size}")
            last4GameWeeks.forEach {
                homeOrAway[it.event!!] = DoubleType(
                    element.team == it.teamH,
                    it
                )
            }
            homeOrAway.forEach {
                last4difficulties += if (it.value.first) {
                    it.value.second.teamADifficulty ?: 0
                } else {
                    it.value.second.teamHDifficulty ?: 0
                }
            }
            Log.d("Calculate${element.webName}","Last difficulties is ${last4difficulties}")
        }catch(e:Exception){
            e.logStacktrace("Calculate${element.webName}")
        }
        Log.d("Calculate${element.webName}", "Got last 4 gameweeks")
        next3GameWeeks = elementSummary.fixtures.filter {
            it.event.toIntOr(-1) >= currentGameweek[0].id.toIntOr(100) && it.event.toIntOr(100) < currentGameweek[0].id.toIntOr(-1) + 4
        }
        Log.d("Calculate${element.webName}", "Got next 3 gameweeks, size = ${next3GameWeeks.size}")
    }catch (e:Exception){
        e.logStacktrace("Calculate${element.webName}")
        return 0f
    }
    return try{
        var chanceOfPlaying = (element.chanceOfPlayingThisRound.toString().toFloatOrNull() ?: 0f)/100
        if (chanceOfPlaying == 0f){
            chanceOfPlaying = 1f
        }
        var log = Log.d("Calculate${element.webName}", "Got chance of playing, $chanceOfPlaying")
        val pointsPerGame = element.pointsPerGame.toString().toFloatOrNull() ?: 0f
        log = Log.d("Calculate${element.webName}", "Got points per game, $pointsPerGame")
        var formDivider = last4GameWeeks.size
        if(formDivider == 0) formDivider = 4
        val formAverage = (
                (
                        element.form.toString().toFloatOrNull() ?: (0f *
                                (((last4difficulties)) / formDivider))
                        )
                )

        var ictAverage = (
                (element.ictIndex.toString().toFloatOrNull()?:0f)/fixtures.size
                )
        log = Log.d("Calculate${element.webName}", "Got ict average, $ictAverage")
        log = Log.d("Calculate${element.webName}", "Api ict index is ${element.ictIndex}")
        log = Log.d("Calculate${element.webName}", "Api minutes is ${element.minutes}")
        try {
            next3GameWeeks.forEach {
                nextDifficulty+= it.difficulty!!
            }
            nextDifficulty/= next3GameWeeks.size
            log = Log.d("Calculate${element.webName}", "Got next difficulty, $nextDifficulty")
        }catch (e: Exception){
            nextDifficulty = 3f
        }
        if(nextDifficulty == 0f){
            nextDifficulty = 1f
        }
        val score = chanceOfPlaying*((pointsPerGame+formAverage+ictAverage)/nextDifficulty)
        log = Log.d("Calculate${element.webName}", "Score is $score")
        score
    }catch(e: Exception){
        val bob = e.printStackTrace()
        0f
    }
}