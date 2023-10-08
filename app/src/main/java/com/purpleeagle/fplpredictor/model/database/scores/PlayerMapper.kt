package com.purpleeagle.fplpredictor.model.database.scores

import com.purpleeagle.fplpredictor.Scores
import com.purpleeagle.fplpredictor.model.models.enums.DataHolder

fun DataHolder.toScoreSql(): Scores{
    return Scores(
        id = 0,
        name = this.player.webName?:"",
        score = this.score.toDouble(),
        position = this.player.elementType?.toLong()?:10L,
        cost = this.player.nowCost?.toDouble()?:(0).toDouble()
    )
}