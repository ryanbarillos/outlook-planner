package com.outlook.planner.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.outlook.planner.ui.navigation.destination.DestinationHome
import com.outlook.planner.ui.navigation.destination.DestinationPlanEdit
import com.outlook.planner.ui.navigation.destination.DestinationPlanMake
import com.outlook.planner.ui.pages.home.Home
import com.outlook.planner.ui.pages.makeplan.PlanMake

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun OutlookPlannerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinationHome.route,
        modifier = modifier
    ) {
        /**
         * Home page
         */
        composable(route = DestinationHome.route) {
            Home(
                modifier = modifier,
                pageCurrent = DestinationHome.route,
                navigateToPlanMake = { navController.navigate(route = DestinationPlanMake.route) },
                navigateToPlanEdit = { planId -> navController.navigate(route = "${DestinationPlanEdit.route}/${planId}") }
            )
        }
        /**
         * Make Plan page
         */
        composable(route = DestinationPlanMake.route) {
            PlanMake(
                modifier = modifier,
                pageCurrent = DestinationPlanEdit.route,
                navigateBack = {
                    navController.popBackStack()
                },
            )
        }
        /**
         * Edit Plan page
         * (AKA Make Plan page with a Plan object passed)
         */
        composable(
            route = DestinationPlanEdit.routeWithId,
            arguments = listOf(navArgument(name = DestinationPlanEdit.PLAN_ID) {
                type = NavType.IntType
            })
        ) {
            Log.d("Args", it.arguments?.getInt(DestinationPlanEdit.PLAN_ID).toString())
            PlanMake(
                modifier = modifier,
                pageCurrent = DestinationPlanEdit.route,
                navigateBack = { navController.popBackStack() },
            )
        }
    }
}