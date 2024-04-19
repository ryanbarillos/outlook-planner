package com.outlook.planner.data.plan.database

import com.outlook.planner.data.plan.PlanEntity
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [PlanEntity] from a given data source.
 */
interface PlanRepository {
    /**
     * Retrieve all the Plans from the the given data source.
     */
    fun getPlanAll(): Flow<List<PlanEntity>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getPlanOne(id: Int): Flow<PlanEntity>

    /**
     * Insert + Update Plan in the data source
     */
    suspend fun planUpsert(planEntity: PlanEntity)

    /**
     * Delete Plan from the data source
     */
    suspend fun planDelete(planEntity: PlanEntity)
}