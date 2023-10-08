package com.purpleeagle.fplpredictor.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.purpleeagle.fplpredictor.view.components.PlayerItem
import com.purpleeagle.fplpredictor.viewmodel.states.TestState
import com.purpleeagle.fplpredictor.viewmodel.viewmodels.Events
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.purpleeagle.fplpredictor.model.functions.bestAveragePosition

@Composable
fun HomeScreen(
    state: TestState,
    onEvent: (Events) -> Unit
) {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabTitles = listOf("ATK", "MID", "DEF", "GK")
    Column {
        if(state.dataHolderList.isEmpty()){
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Using outdated information from last thursday")
            }
        }
        Button(onClick = { onEvent(Events.StartClicked) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "start")
        }
        Text(
            text =
                if(state.load!="") state.load
                else "${state.bestAveragePosition()}"
        )
        TabRow(selectedTabIndex = tabIndex) {
            tabTitles.forEachIndexed { index, s ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {tabIndex = index},
                    text = { Text(text = s) }
                )
            }
        }
        when(tabIndex){
            0 -> {
                LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)){
                    items(state.attackerList){
                        PlayerItem(dataHolder = it)
                    }
                    if(state.attackerList.isEmpty()){
                        items(state.offlineAttackerList){
                            PlayerItem(scores = it)
                        }
                    }
                }
            }
            1 -> {
                LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)){
                    items(state.midfielderList){
                        PlayerItem(dataHolder = it)
                    }
                    if(state.midfielderList.isEmpty()){
                        items(state.offlineMidfielderList){
                            PlayerItem(scores = it)
                        }
                    }
                }
            }
            2 -> {
                LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)){
                    items(state.defenderList){
                        PlayerItem(dataHolder = it)
                    }
                    if(state.defenderList.isEmpty()){
                        items(state.offlineDefenderList){
                            PlayerItem(scores = it)
                        }
                    }
                }
            }
            3 -> {
                LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)){
                    items(state.goalkeeperList){
                        PlayerItem(dataHolder = it)
                    }
                    if(state.goalkeeperList.isEmpty()){
                        items(state.offlineGoalkeeperList){
                            PlayerItem(scores = it)
                        }
                    }
                }
            }
        }
    }
}