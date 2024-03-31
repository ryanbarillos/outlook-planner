package com.example.outlook.planner.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlookPlannerBottomBar(modifier: Modifier = Modifier) {
    ExtendedFloatingActionButton(
        onClick = { null },
        icon = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Extended floating action button."
            )
       },
        text = {
            Text(text = "New Plan")
       },
    )

}