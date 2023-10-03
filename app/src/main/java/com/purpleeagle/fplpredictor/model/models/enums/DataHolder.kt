package com.purpleeagle.fplpredictor.model.models.enums

import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.Player
import com.purpleeagle.fplpredictor.model.models.elementsummary.ElementSummary

data class DataHolder(
    val player: Player,
    val elementSummary: ElementSummary,
    val score: Float
)

fun DataHolderList(
    players: List<Player>,
    elementSummaries: Map<Int, ElementSummary>,
    scores: Map<Int, Float>
): List<DataHolder>{
    val list: MutableList<DataHolder> = mutableListOf()
    for(i in players.indices){
        list.add(
            DataHolder(
            players[i],
            elementSummaries[players[i].id!!]!!,
            scores[players[i].id!!]!!
        )
        )
    }
    return list
}