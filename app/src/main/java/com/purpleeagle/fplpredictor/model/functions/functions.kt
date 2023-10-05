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
fun TestState.bestAveragePosition(): String{
    try {
        val bestAttackers = attackerList.take(5)
        val bestMidfielders = midfielderList.take(5)
        val bestDefenders = defenderList.take(5)

        var aScore = 0f
        var mScore = 0f
        var dScore = 0f

        for (i in 0 until 5) {
            aScore += bestAttackers[i].score
            mScore += bestMidfielders[i].score
            dScore += bestDefenders[i].score
        }

        val averages = listOf(aScore / 5, mScore / 5, dScore / 5)
        val index = averages.indexOf(averages.max())
        Log.d("BestPosition", "$averages")
        return when (index) {
            0 -> "Attackers"
            1 -> "Midfielders"
            2 -> "Defenders"
            else -> ""
        }
    }catch (e: Exception){
        return ""
    }
}