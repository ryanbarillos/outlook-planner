package com.example.outlook.planner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.outlook.planner.ui.navigation.destination.DestinationHome
import com.example.outlook.planner.ui.navigation.destination.DestinationMakePlan
import com.example.outlook.planner.ui.pages.home.Home
import com.example.outlook.planner.ui.pages.makeplan.MakePlan

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
                navigateToPlanMake = {
                    navController.navigate(DestinationMakePlan.route)
                }
            )
        }
        /**
         * Make Plan page
         */
        composable(route = DestinationMakePlan.route) {
            MakePlan(
                modifier = modifier,
                pageCurrent = DestinationMakePlan.route,
                navigateBack = {
                    navController.popBackStack()
                },
//                onNavigateUp = {
//                    navController.navigateUp()
//                }

            )
        }
    }
}