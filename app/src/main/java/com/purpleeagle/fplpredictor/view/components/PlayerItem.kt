package com.purpleeagle.fplpredictor.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.purpleeagle.fplpredictor.model.functions.roundToDecimalPlaces
import com.purpleeagle.fplpredictor.model.models.enums.DataHolder

@Composable
fun PlayerItem(
    dataHolder: DataHolder
) {
    Box{
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = dataHolder.player.webName ?: "")
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = dataHolder.score.roundToDecimalPlaces(2).toString())
            }
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Column(horizontalAlignment = Alignment.End) {
                Text(text = "£${(dataHolder.player.nowCost.toString().toFloatOrNull() ?: 0f) / 10}")
            }
        }
    }
}