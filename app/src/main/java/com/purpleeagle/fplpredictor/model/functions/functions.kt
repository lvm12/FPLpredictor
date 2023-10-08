package com.purpleeagle.fplpredictor.model.functions

import android.util.Log
import androidx.compose.runtime.Composable
import com.purpleeagle.fplpredictor.viewmodel.states.TestState


fun Float.roundToDecimalPlaces(places: Int): Float{
    val base: String
    val indexDecimal = toString().indexOf(".")
    try {
        val string = this.toString()
        base = string.take(indexDecimal + 1 + places)
        if (string[indexDecimal + 3].code < 5) {
            return base.toFloat()
        }
        var adder = 1f
        for (i in 0 until places) {
            adder /= 10
        }
        return (base.toFloat() + adder).toString().take(indexDecimal+1+places).toFloat()
    }catch (e:Exception){
        return toString().take(indexDecimal + 1 + places).toFloat()
    }
}

fun Double.roundToDecimalPlaces(places: Int): Float{
    val base: String
    val indexDecimal = toString().indexOf(".")
    try {
        val string = this.toString()
        base = string.take(indexDecimal + 1 + places)
        if (string[indexDecimal + 3].code < 5) {
            return base.toFloat()
        }
        var adder = 1f
        for (i in 0 until places) {
            adder /= 10
        }
        return (base.toFloat() + adder).toString().take(indexDecimal+1+places).toFloat()
    }catch (e:Exception){
        return toString().take(indexDecimal + 1 + places).toFloat()
    }
}

fun Exception.logStacktrace(tag: String){
    Log.d(tag, stackTraceToString())
}

fun Int?.toIntOr(x: Int): Int{
    return try {
        this!!
    }catch (_:Exception) {x}
}

fun String?.toIntOr(x: Int): Int{
    return try {
        this!!.toInt()
    }catch (e:Exception) {x}
}
@Composable
fun TestState.bestAveragePosition(): List<String>{
    try {
        val bestAttackers = attackerList.take(5)
        val bestMidfielders = midfielderList.take(5)
        val bestDefenders = defenderList.take(5)

        var aScore = 0f
        var mScore = 0f
        var dScore = 0f

        for (i in 0 until listOf<Int>(bestAttackers.size, bestMidfielders.size, bestDefenders.size).min()) {
            aScore += bestAttackers[i].score
            mScore += bestMidfielders[i].score
            dScore += bestDefenders[i].score
        }

        val averages = listOf(aScore / 5, mScore / 5, dScore / 5)
        val sorted = averages.sortedDescending()
        val positionList = mutableListOf<String>()
        if(aScore!=0f && mScore!=0f && dScore!=0f) {
            for (i in 0 until 3) {
                when (sorted[i]) {
                    aScore / 5 -> positionList.add("Attackers")
                    mScore / 5 -> positionList.add("Midfielders")
                    dScore / 5 -> positionList.add("Defenders")
                }
            }
        }
        if(positionList.isNotEmpty()) return positionList
        else{
            val offlineAttackers = offlineAttackerList.take(5)
            val offlineMidfielders = offlineMidfielderList.take(5)
            val offlineDefenders = offlineDefenderList.take(5)


            var offAScore = 0.0
            var offMScore = 0.0
            var offDScore = 0.0
            for(i in 0 until 5){
                offAScore += offlineAttackers[i].score
                offMScore += offlineMidfielders[i].score
                offDScore += offlineDefenders[i].score
            }
            val offlineAverages = listOf(offAScore/5,offMScore/5, offDScore/5)
            val offlineSorted = offlineAverages.sortedDescending()
            val offlinePositionList = mutableListOf<String>()
            for(i in 0 until 3){
                when(offlineSorted[i]){
                    offAScore/5 -> offlinePositionList.add("Attackers")
                    offMScore/5 -> offlinePositionList.add("Midfielders")
                    offDScore/5 -> offlinePositionList.add("Defenders")
                }
            }
            return offlinePositionList
        }
    }catch (e: Exception){
        return emptyList()
    }
}