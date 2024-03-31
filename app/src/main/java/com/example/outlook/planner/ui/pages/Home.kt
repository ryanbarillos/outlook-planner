package com.example.outlook.planner.ui.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.outlook.planner.OutlookPlannerWeatherStatus
import com.example.outlook.planner.ui.OutlookPlannerCard
import com.example.outlook.planner.ui.OutlookPlannerFAB
import com.example.outlook.planner.ui.OutlookPlannerTopBar
import com.example.outlook.planner.ui.design.ViewingArea

@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold (
        topBar = {
            /**
             * Weather Status
             */
//            ViewingArea()
        },
        floatingActionButton = {
            OutlookPlannerFAB(navController = navController)
        }
    ) {
        LazyColumn (modifier = Modifier.padding(it)) {
            item {
                ViewingArea()
            }
            items(1024) {
                OutlookPlannerCard(modifier = Modifier.padding(16.dp))
            }
        }
    }
}