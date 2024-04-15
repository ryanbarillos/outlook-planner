package com.example.outlook.planner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
        startDestination = OutlookPlannerScreen.Home.name,
        modifier = modifier
    ) {
        /**
         * Home page
         */
        composable(route = OutlookPlannerScreen.Home.name) {
            Home(
                modifier = modifier,
                navController = navController
            )
        }
        /**
         * Make Plan page
         */
        composable(route = OutlookPlannerScreen.MakePlan.name) {
            val context = LocalContext.current
            MakePlan(
                modifier = modifier,
                navController = navController
            )
        }
    }
}