package com.outlook.planner.ui.navigation.destination

import com.outlook.planner.R
import com.outlook.planner.ui.navigation.NavigationDestination

object DestinationPlanMake: NavigationDestination {
//    override val route = R.string.route_plan_make.toString()
    override val route = "plan_make"
    override val titleRes = R.string.name_plan_make
    /**
     * Additional values for routing
     */
    const val PLAN_ID: String = "planId"
    val routeWithId: String = "${this.route}/{$PLAN_ID}"
}