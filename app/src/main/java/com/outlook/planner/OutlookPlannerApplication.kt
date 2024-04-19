package com.outlook.planner

import android.app.Application
import com.outlook.planner.data.AppContainer
import com.outlook.planner.data.AppDataContainer

class OutlookPlannerApplication : Application() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}