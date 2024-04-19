package com.outlook.planner.data.plan

import com.outlook.planner.ui.pages.makeplan.PlanMakeUiState

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
 * Extension function to convert [PlanEntity] to [PlanMakeUiState]
 * Initially make it false so that changes are a must to complete
 */
fun PlanEntity.toMakePlanUiState(fieldNotEmptyAtAll: Boolean = false): PlanMakeUiState = PlanMakeUiState(
    plan = this.toPlan(),
    fieldNotEmptyAll = fieldNotEmptyAtAll
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