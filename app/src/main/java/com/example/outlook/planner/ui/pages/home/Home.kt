package com.example.outlook.planner.ui.pages.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.outlook.planner.ui.AppViewModelProvider
import com.example.outlook.planner.ui.components.AppFAB
import com.example.outlook.planner.ui.components.PlanCard
import com.example.outlook.planner.ui.design.ViewingArea

@Composable
fun Home(
    modifier: Modifier = Modifier,
    navigateToPlanMake: () -> Unit ,
    pageCurrent: String,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    /**
     * Immutable variables
     */
    val homeUiState by viewModel.homeUiState.collectAsState()
    val planList = homeUiState.planList

    Scaffold (
        floatingActionButton = {
            AppFAB(
                pageCurrent = pageCurrent,
                onClick = navigateToPlanMake
            )
        },
        modifier = modifier,
    ) {
        LazyColumn (modifier = modifier.padding(it)) {
            item {
                ViewingArea()
            }
            items(planList) { plan ->
                PlanCard(
                    planEntity = plan,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}