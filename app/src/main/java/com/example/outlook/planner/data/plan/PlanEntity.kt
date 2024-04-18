package com.example.outlook.planner.data.plan

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar

/**
 * Plan Entity
 *
 * SAME AS [Plan], but designated for SQLite / RoomDB
 */
@Entity(tableName = PLAN_NAME_TABLE)
data class PlanEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val note: String,
    val year: Int = Calendar.getInstance().get(Calendar.YEAR),
    val month: Int = Calendar.getInstance().get(Calendar.MONTH),
    val date: Int = Calendar.getInstance().get(Calendar.DATE),
    val hour: Int = Calendar.getInstance().get(Calendar.HOUR),
    val minute: Int = Calendar.getInstance().get(Calendar.MINUTE),
)