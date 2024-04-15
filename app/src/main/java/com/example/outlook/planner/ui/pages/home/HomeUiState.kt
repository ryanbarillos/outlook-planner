package com.example.outlook.planner.ui.pages.home

import com.example.outlook.planner.data.plan.Plan

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(
    val planList: List<Plan> = listOf()
)
