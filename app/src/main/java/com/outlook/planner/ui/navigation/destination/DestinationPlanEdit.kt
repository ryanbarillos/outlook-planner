package com.outlook.planner.ui.navigation.destination

import com.outlook.planner.R
import com.outlook.planner.ui.navigation.NavigationDestination

object DestinationPlanEdit: NavigationDestination {
    override val route = "plan_edit"
    override val titleRes = R.string.name_plan_edit
    /**
     * Additional values for routing
     */
    const val PLAN_ID: String = "planId"
    val routeWithId: String = "$route/{$PLAN_ID}"
}