package com.purpleeagle.fplpredictor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.purpleeagle.fplpredictor.model.database.scores.DatabaseDriverFactory
import com.purpleeagle.fplpredictor.model.database.scores.ImplementedDataSource
import com.purpleeagle.fplpredictor.model.network.FplApiService
import com.purpleeagle.fplpredictor.ui.theme.FPLPredictorTheme
import com.purpleeagle.fplpredictor.viewmodel.viewmodels.TestViewModel
import com.purpleeagle.fplpredictor.viewmodel.viewmodels.TestViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sql = ImplementedDataSource(
            db = ScoresDatabase(
                driver = DatabaseDriverFactory(this).create()
            )
        )
        val factory = TestViewModelFactory(FplApiService(), sql)
        val viewModel = ViewModelProvider(this, factory)[TestViewModel::class.java]
        viewModel.selectAll()
        setContent {
            FPLPredictorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(viewModel)
                }
            }
        }
    }
}

