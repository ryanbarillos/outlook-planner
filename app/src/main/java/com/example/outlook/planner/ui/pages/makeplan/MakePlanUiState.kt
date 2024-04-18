package com.example.outlook.planner.ui.pages.makeplan

import com.example.outlook.planner.data.plan.Plan
import java.time.LocalDate
import java.time.LocalTime

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
        year = LocalDate.now().year,
        month = LocalDate.now().monthValue,
        date = LocalDate.now().dayOfMonth,
        hour = LocalTime.now().hour,
        minute = LocalTime.now().minute,
        ),
    val fieldNotEmptyAll: Boolean = false
)


