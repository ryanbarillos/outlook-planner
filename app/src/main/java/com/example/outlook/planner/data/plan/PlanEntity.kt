package com.example.outlook.planner.data.plan

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Plan Entity
 *
 * SAME AS [Plan], but designated for SQLite / RoomDB
 */
@Entity(tableName = PLAN_NAME_TABLE)
data class PlanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val note: String,
    val timeToHappen: Long = 0,
    val dateToHappen: Long = 0
)