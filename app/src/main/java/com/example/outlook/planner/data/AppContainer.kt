package com.example.outlook.planner.data

import android.content.Context
import com.example.outlook.planner.data.plan.database.PlanDatabase
import com.example.outlook.planner.data.plan.database.PlanRepository
import com.example.outlook.planner.data.plan.database.PlanRepositoryOffline

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val planRepository: PlanRepository
}

/**
 * [AppContainer] implementation that provides instance of [PlanRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [PlanRepository]
     */
    override val planRepository: PlanRepository by lazy {
        PlanRepositoryOffline(PlanDatabase.getDatabase(context).planDao())
    }
}