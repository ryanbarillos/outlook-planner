package com.example.outlook.planner.data.plan.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.outlook.planner.data.plan.PLAN_NAME_TABLE
import com.example.outlook.planner.data.plan.PlanEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanDao {
    /**
     * Insert + Update plan(s)
     */
    @Upsert
    suspend fun upsert(planEntity: PlanEntity)

    /**
     * Delete note(s)
     */
    @Delete
    suspend fun delete(planEntity: PlanEntity)

    /**
     * Return ordered list of plans
     */
    @Query("SELECT * FROM $PLAN_NAME_TABLE ORDER BY COALESCE(year, month, date, hour, minute) ASC")
    fun getPlanAll(): Flow<List<PlanEntity>>

    /**
     * Return one plan by id
     */
    @Query("SELECT * from $PLAN_NAME_TABLE WHERE id = :id")
    fun getPlanOne(id: Int): Flow<PlanEntity>
}