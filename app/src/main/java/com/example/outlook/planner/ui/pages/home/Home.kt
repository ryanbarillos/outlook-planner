package com.example.outlook.planner.ui.pages.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.outlook.planner.data.plan.PlanEntity
import com.example.outlook.planner.ui.components.OutlookPlannerCard
import com.example.outlook.planner.ui.components.OutlookPlannerFAB
import com.example.outlook.planner.ui.design.ViewingArea

@Composable
fun Home(
    modifier: Modifier = Modifier,
    planEntityLists: List<PlanEntity> = emptyList<PlanEntity>(),
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
            items(3) {
                OutlookPlannerCard(modifier = Modifier.padding(16.dp))
            }
            items(planEntityLists) { plan ->
                OutlookPlannerCard(
                    planEntity = plan,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}