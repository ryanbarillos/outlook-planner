package com.example.outlook.planner.ui.pages.makeplan

import com.example.outlook.planner.data.plan.Plan

/**
 * Data class that represents the plan UI state
 *
 * Uses:
 * - Hold current plan
 * - Check if all fields are not empty
 */
data class MakePlanUiState(
    val plan: Plan = Plan(
        note = ""
    ),
    val fieldNotEmptyAll: Boolean = false
)


