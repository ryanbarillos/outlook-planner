package com.example.outlook.planner.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.outlook.planner.OutlookPlannerScreen

@Composable
fun OutlookPlannerFAB(
    modifier: Modifier = Modifier,
    pageCurrent: String = "",
    navController: NavHostController
    ) {
    when(pageCurrent) {
        /**
         * Current page is New PLan
         */
        "NewPlan" -> {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate(OutlookPlannerScreen.Home.name) },
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
                onClick = { navController.navigate(OutlookPlannerScreen.NewPlan.name) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add new plan button."
                    )
                },
                text = {
                    Text(text = "New Plan")
                }
            )
        }
    }
}