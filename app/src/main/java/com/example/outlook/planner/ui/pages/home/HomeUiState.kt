package com.example.outlook.planner.ui.pages.home

import com.example.outlook.planner.data.plan.PlanEntity

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(
    val planList: List<PlanEntity> = listOf()
)
