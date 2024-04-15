package com.example.outlook.planner.data.plan.database

import com.example.outlook.planner.data.plan.PlanEntity
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [PlanEntity] from a given data source.
 */
interface PlanRepository {
    /**
     * Retrieve all the Plans from the the given data source.
     */
    fun getAllPlans(): Flow<List<PlanEntity>>

    /**
     * Insert + Update Plan in the data source
     */
    suspend fun upsertPlan(planEntity: PlanEntity)

    /**
     * Delete Plan from the data source
     */
    suspend fun deletePlan(planEntity: PlanEntity)
}