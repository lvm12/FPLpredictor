package com.purpleeagle.fplpredictor.model.database.scores

import com.purpleeagle.fplpredictor.Scores
import com.purpleeagle.fplpredictor.model.models.enums.DataHolder
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

interface DataSource {
    fun getScores(context: CoroutineContext): Flow<List<Scores>>
    suspend fun insertScore(score: Scores)
    suspend fun deleteTable()
    suspend fun batchInsert(scores: List<DataHolder>)
    suspend fun vacuumTable()
}