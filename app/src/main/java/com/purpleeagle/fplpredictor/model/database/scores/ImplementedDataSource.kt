package com.purpleeagle.fplpredictor.model.database.scores

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.purpleeagle.fplpredictor.Scores
import com.purpleeagle.fplpredictor.ScoresDatabase
import com.purpleeagle.fplpredictor.model.models.enums.DataHolder
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

class ImplementedDataSource(
    db: ScoresDatabase
): DataSource{
    private val queries = db.scoresQueries
    override fun getScores(context: CoroutineContext): Flow<List<Scores>> {
        return queries
            .selectAll()
            .asFlow()
            .mapToList(context)
    }

    override suspend fun insertScore(score: Scores) {
        queries.insertPlayer(score)
    }

    override suspend fun deleteTable() {
        queries.deleteTable()
    }

    override suspend fun batchInsert(scores: List<DataHolder>) {
        scores.forEach { dataHolder->
            queries.insertPlayer(dataHolder.toScoreSql())
        }
    }

    override suspend fun vacuumTable() {
        queries.vacuumTable()
    }


}
