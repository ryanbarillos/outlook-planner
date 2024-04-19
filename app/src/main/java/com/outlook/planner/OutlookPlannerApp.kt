package com.outlook.planner

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.outlook.planner.ui.navigation.OutlookPlannerNavHost

@Composable
fun OutlookPlannerApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    OutlookPlannerNavHost(
        navController = navController,
        modifier = modifier
    )
}