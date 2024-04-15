package com.example.outlook.planner.data.plan.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.outlook.planner.data.plan.PLAN_TABLE_NAME
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
    @Query("SELECT * FROM $PLAN_TABLE_NAME ORDER BY dateToHappen, timeToHappen ASC")
    fun getAllPlans(): Flow<List<PlanEntity>>

}