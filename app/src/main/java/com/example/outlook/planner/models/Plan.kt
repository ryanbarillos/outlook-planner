package com.example.outlook.planner.models

import androidx.annotation.StringRes

data class Plan(
    val title: String,
    val description: String,
    val month: Int = 0,
    val date: Int = 0,
    val year: Int = 0
)
