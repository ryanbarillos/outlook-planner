package com.outlook.planner.ui.navigation.destination

import com.outlook.planner.R
import com.outlook.planner.ui.navigation.NavigationDestination

object DestinationPlanEdit: NavigationDestination {
    override val route = R.string.route_plan_edit.toString()
    override val titleRes = R.string.name_plan_edit

    /**
     * Additional values for routing
     */
    const val PLAN_ID: String = "id"
    val routeWithId: String = "${route}/${PLAN_ID}"


}