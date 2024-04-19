package com.outlook.planner.data.plan.database

import com.outlook.planner.data.plan.PlanEntity
import kotlinx.coroutines.flow.Flow

class PlanRepositoryOffline(private val planDao: PlanDao) : PlanRepository {
    override fun getPlanAll(): Flow<List<PlanEntity>> = planDao.getPlanAll()

    override fun getPlanOne(id: Int): Flow<PlanEntity> = planDao.getPlanOne(id)

    override suspend fun planUpsert(planEntity: PlanEntity) = planDao.upsert(planEntity)

    override suspend fun planDelete(planEntity: PlanEntity) = planDao.delete(planEntity)

}