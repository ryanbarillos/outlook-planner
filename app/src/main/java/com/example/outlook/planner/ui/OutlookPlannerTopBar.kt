package com.example.outlook.planner.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlookPlannerTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
                Row {
                    Text(
                        text = "Calgary, AB",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
        },
        modifier = modifier)
}