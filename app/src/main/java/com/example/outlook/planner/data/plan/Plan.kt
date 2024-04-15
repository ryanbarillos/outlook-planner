package com.example.outlook.planner.data.plan

data class Plan(
    val id: Int = 0,
    val note: String,
    val timeToHappen: Long = 0,
    val dateToHappen: Long = 0
)

/**
 * Extension function to convert [Plan] to [PlanEntity]
 */
fun Plan.toEntity(): PlanEntity = PlanEntity(
    id = id,
    note = note,
    timeToHappen = timeToHappen,
    dateToHappen = dateToHappen
)