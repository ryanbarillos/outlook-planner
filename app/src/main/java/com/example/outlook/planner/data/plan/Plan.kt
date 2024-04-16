package com.example.outlook.planner.data.plan

data class Plan(
    val id: Int = 0,
    val note: String,
    val timeToHappen: Long = 0,
    val dateToHappen: Long = 0
)