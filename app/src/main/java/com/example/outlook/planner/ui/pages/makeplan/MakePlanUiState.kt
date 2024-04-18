package com.example.outlook.planner.ui.pages.makeplan

import com.example.outlook.planner.data.plan.Plan
import java.time.LocalDateTime

/**
 * Data class that represents the plan UI state
 *
 * Uses:
 * - Hold current plan
 * - Check if all fields are not empty
 * - To show MaterialTimePicker or not
 * - To show MaterialDatePicker or not
 */
data class MakePlanUiState(
    val plan: Plan = Plan(
        note = "",
        year = LocalDateTime.now().year,
        month = LocalDateTime.now().monthValue,
        date = LocalDateTime.now().dayOfMonth,
        hour = LocalDateTime.now().hour,
        minute = LocalDateTime.now().minute,
        ),
    val fieldNotEmptyAll: Boolean = false
)


