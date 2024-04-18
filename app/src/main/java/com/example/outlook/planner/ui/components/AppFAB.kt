package com.example.outlook.planner.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.outlook.planner.ui.navigation.OutlookPlannerScreen
import com.example.outlook.planner.ui.navigation.destination.DestinationMakePlan

@Composable
fun AppFAB(
    pageCurrent: String,
    onClick: () -> Unit = {}

    ) {
    when(pageCurrent) {
        /**
         * Current page is New PLan
         */
        DestinationMakePlan.route -> {
            ExtendedFloatingActionButton(
                onClick = onClick,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "Create plan button."
                    )
                },
                text = {
                    Text(text = "Create Plan")
                },
            )
        }
        /**
         * current page is Home
         */
        else -> {
            ExtendedFloatingActionButton(
                onClick = onClick,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add plan button."
                    )
                },
                text = {
                    Text(text = "New Plan")
                }
            )
        }
    }
}