package com.outlook.planner.data.plan

/**
 * Variables to use
 */
const val PLAN_NAME_TABLE = "plans"
const val PLAN_NAME_DB = "plans_database"

/**
 * Extension function to convert [PlanEntity] to [Plan]
 */
fun PlanEntity.toPlan(): Plan = Plan(
    id = id,
    note = note,
    year = year,
    month = month,
    date = date,
    hour = hour,
    minute = minute,
)

/**
 * Extension function to convert [Plan] to [PlanEntity]
 */
fun Plan.toEntity(): PlanEntity = PlanEntity(
    id = id,
    note = note,
    year = year,
    month = month,
    date = date,
    hour = hour,
    minute = minute,
)