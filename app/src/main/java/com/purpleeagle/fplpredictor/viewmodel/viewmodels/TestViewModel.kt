package com.purpleeagle.fplpredictor.viewmodel.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purpleeagle.fplpredictor.model.database.scores.ImplementedDataSource
import com.purpleeagle.fplpredictor.model.models.enums.DataHolderList
import com.purpleeagle.fplpredictor.model.network.FplApiService
import com.purpleeagle.fplpredictor.model.scorecalculator.calculate
import com.purpleeagle.fplpredictor.viewmodel.states.TestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class TestViewModel(
    private val FplApiService: FplApiService,
    private val dataSource: ImplementedDataSource
): ViewModel() {

    private val _state = MutableStateFlow(TestState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            TestState()
        )
    fun selectAll(){
        viewModelScope.launch {
            val dataBasePlayers = dataSource.getScores(coroutineContext).first()
            _state.update { state ->
                state.copy(
                    offlineList = dataBasePlayers,
                    offlineAttackerList = dataBasePlayers.filter { it.position == 4L },
                    offlineMidfielderList = dataBasePlayers.filter { it.position == 3L },
                    offlineDefenderList = dataBasePlayers.filter { it.position == 2L },
                    offlineGoalkeeperList = dataBasePlayers.filter { it.position == 1L }
                )
            }
        }
    }
    fun onEvent(event: Events){
        when(event){
            is Events.BootModelGot -> {}
            is Events.ElementSumGot -> {}
            Events.StartClicked -> {
                try {
                    val bootstrapJob = viewModelScope.launch {
                        _state.update {
                            it.copy(
                                load = "Getting bootstrap"
                            )
                        }
                        _state.update {
                            it.copy(
                                bootStrapModel = FplApiService.getBootStrap().getOrThrow()
                            )
                        }
                        Log.d(
                            "ViewModel",
                            "Got bootstrap, size of player list is ${_state.value.bootStrapModel!!.players.size}"
                        )
                    }
                    val playerListSetJob = viewModelScope.launch {
                        bootstrapJob.join()
                        _state.update {
                            it.copy(
                                playerList = _state.value.bootStrapModel!!.players
                            )
                        }
                    }
                    val elementSummaryGetJob = viewModelScope.launch {
                        playerListSetJob.join()
                        if (_state.value.bootStrapModel != null) {
                            for (i in _state.value.bootStrapModel!!.players) {
                                _state.update {
                                    it.copy(
                                        load = "Getting ${i.webName}"
                                    )
                                }

                                _state.value.elementSummaries.put(
                                    i.id!!, FplApiService.getElementSummaryById(i.id!!).getOrThrow()
                                )
                            }
                        }
                    }
                    val calculateScoreJob = viewModelScope.launch {
                        elementSummaryGetJob.join()
                        Log.d("ViewModel", "Getting fixtures")
                        val fixtures = FplApiService.getFixtures().getOrThrow()
                        Log.d("ViewModel", "Size of fixtures is ${fixtures.size}")
                        _state.value.playerList.forEachIndexed { index, player ->
                            _state.update {
                                it.copy(
                                    load = "Calculating ${player.webName}"
                                )
                            }
                            _state.value.scoreList.put(
                                player.id!!,
                                calculate(
                                    _state.value.bootStrapModel!!,
                                    player,
                                    _state.value.elementSummaries[player.id!!]!!,
                                    fixtures
                                )
                            )
                        }

                        _state.update { state ->
                            state.copy(
                                dataHolderList = DataHolderList(
                                    players = _state.value.playerList,
                                    elementSummaries = _state.value.elementSummaries,
                                    scores = _state.value.scoreList
                                ).sortedByDescending {
                                    it.score
                                }.filter {
                                    !it.score.isNaN()
                                }.filter {
                                    !it.score.isInfinite()
                                },
                                load = "",
                                attackerList = DataHolderList(
                                    players = _state.value.playerList,
                                    elementSummaries = _state.value.elementSummaries,
                                    scores = _state.value.scoreList
                                ).sortedByDescending {
                                    it.score
                                }.filter {
                                    !it.score.isNaN()
                                }.filter {
                                    !it.score.isInfinite()
                                }.filter {
                                    it.player.elementType == 4
                                },
                                midfielderList = DataHolderList(
                                    players = _state.value.playerList,
                                    elementSummaries = _state.value.elementSummaries,
                                    scores = _state.value.scoreList
                                ).sortedByDescending {
                                    it.score
                                }.filter {
                                    !it.score.isNaN()
                                }.filter {
                                    !it.score.isInfinite()
                                }.filter {
                                    it.player.elementType == 3
                                },
                                defenderList = DataHolderList(
                                    players = _state.value.playerList,
                                    elementSummaries = _state.value.elementSummaries,
                                    scores = _state.value.scoreList
                                ).sortedByDescending {
                                    it.score
                                }.filter {
                                    !it.score.isNaN()
                                }.filter {
                                    !it.score.isInfinite()
                                }.filter {
                                    it.player.elementType == 2
                                },
                                goalkeeperList = DataHolderList(
                                    players = _state.value.playerList,
                                    elementSummaries = _state.value.elementSummaries,
                                    scores = _state.value.scoreList
                                ).sortedByDescending {
                                    it.score
                                }.filter {
                                    !it.score.isNaN()
                                }.filter {
                                    !it.score.isInfinite()
                                }.filter {
                                    it.player.elementType == 1
                                }
                            )
                        }
                    }
                    viewModelScope.launch {
                        calculateScoreJob.join()
                        dataSource.deleteTable()
                        dataSource.vacuumTable()
                        dataSource.batchInsert(_state.value.dataHolderList)
                    }
                }catch (e: Exception){
                    _state.update { it.copy(
                        load = "No internet connection"
                    ) }
                }
            }
        }
    }
}