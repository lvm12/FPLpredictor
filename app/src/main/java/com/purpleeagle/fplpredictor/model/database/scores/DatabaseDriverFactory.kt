package com.purpleeagle.fplpredictor.model.database.scores

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.purpleeagle.fplpredictor.ScoresDatabase

class DatabaseDriverFactory(
    private val context: Context
) {
    fun create(): SqlDriver {
        return AndroidSqliteDriver(
            ScoresDatabase.Schema,
            context,
            "scores.db"
        )
    }
}