package com.purpleeagle.fplpredictor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.purpleeagle.fplpredictor.view.screens.HomeScreen
import com.purpleeagle.fplpredictor.viewmodel.viewmodels.TestViewModel

@Composable
fun App(
    viewModel: TestViewModel
) {
    val state by viewModel.state.collectAsState()
    HomeScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}