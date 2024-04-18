package com.example.outlook.planner.data.plan

import java.time.LocalDate
import java.time.Month
import java.util.Calendar

data class Plan(
    val id: Int = 0,
    val note: String,
    val year: Int,
    val month: Int,
    val date: Int,
    val hour: Int,
    val minute: Int,
)