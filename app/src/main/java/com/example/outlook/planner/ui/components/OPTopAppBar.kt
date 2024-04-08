package com.example.outlook.planner.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlookPlannerTopBar(modifier: Modifier = Modifier, pageCurrent: String = "") {
    TopAppBar(
        title = {
            Row {
                when(pageCurrent) {
                    "NewPlan" -> {
                        Button(
                            onClick = {
                                null
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowLeft,
                                contentDescription = "Go Back"
                            )
                        }
                    }
                    else -> {
                        Text(
                            text = "Calgary, AB",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        },
        modifier = modifier)
}