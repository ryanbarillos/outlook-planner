package com.outlook.planner.ui.pages.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.outlook.planner.ui.AppViewModelProvider
import com.outlook.planner.ui.components.AppFAB
import com.outlook.planner.ui.components.PlanCard
import com.outlook.planner.ui.design.ViewingArea
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    navigateToPlanMake: () -> Unit,
    navigateToPlanEdit: (Int) -> Unit,
    pageCurrent: String,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    /**
     * Immutable variables
     */
    val coroutineScope = rememberCoroutineScope()
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
            items(items = planList) { planEntity ->
                PlanCard(
                    planEntity = planEntity,
                    modifier = modifier
                        .padding(16.dp)
                        .combinedClickable(
                            onClick = { navigateToPlanEdit(planEntity.id) },
                            onLongClick = { Log.d("ADebug", "Long clicked")
                                coroutineScope.launch {
                                    viewModel.planDelete(planEntity)
                                }
                            }
                        )
                )
            }
        }
    }
}