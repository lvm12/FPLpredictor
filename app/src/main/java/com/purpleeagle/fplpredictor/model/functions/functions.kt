package com.purpleeagle.fplpredictor.model.functions

import android.util.Log



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