package com.example.outlook.planner.data.plan

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Plan Entity
 *
 * SAME AS [Plan], but designated for SQLite / RoomDB
 */
const val PLAN_TABLE_NAME: String = "plans"

/**
 * Database entities
 */
@Entity(tableName = PLAN_TABLE_NAME)
data class PlanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val note: String,
    val timeToHappen: Long = 0,
    val dateToHappen: Long = 0
)

/**
 * Extension function to convert [PlanEntity] to [Plan]
 */
fun PlanEntity.toPlan(): Plan = Plan(
    id = id,
    note = note,
    timeToHappen = timeToHappen,
    dateToHappen = dateToHappen
)