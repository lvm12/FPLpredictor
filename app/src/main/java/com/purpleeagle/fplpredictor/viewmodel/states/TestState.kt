package com.purpleeagle.fplpredictor.viewmodel.states

import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.BootStrapModel
import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.Player
import com.purpleeagle.fplpredictor.model.models.elementsummary.ElementSummary
import com.purpleeagle.fplpredictor.model.models.enums.DataHolder

data class TestState(
    val bootStrapModel: BootStrapModel? = null,
    val elementSummaries: MutableMap<Int, ElementSummary> = mutableMapOf(),
    val load: String = "",
    val playerList: List<Player> = emptyList(),
    val scoreList: MutableMap<Int, Float> = mutableMapOf(),
    val dataHolderList: List<DataHolder> = emptyList(),
    val attackerList: List<DataHolder> = emptyList(),
    val midfielderList: List<DataHolder> = emptyList(),
    val defenderList: List<DataHolder> = emptyList(),
    val goalkeeperList: List<DataHolder> = emptyList()
)
