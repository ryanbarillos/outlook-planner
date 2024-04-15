package com.example.outlook.planner.data.plan.database

import com.example.outlook.planner.data.plan.PlanEntity
import kotlinx.coroutines.flow.Flow

class PlanRepositoryOffline(private val planDao: PlanDao) : PlanRepository {
    override fun getAllPlans(): Flow<List<PlanEntity>> = planDao.getAllPlans()

    override suspend fun upsertPlan(planEntity: PlanEntity) = planDao.upsert(planEntity)

    override suspend fun deletePlan(planEntity: PlanEntity) = planDao.delete(planEntity)

}