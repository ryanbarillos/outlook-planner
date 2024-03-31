package com.example.outlook.planner.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.outlook.planner.ui.OutlookPlannerFAB
import com.example.outlook.planner.ui.design.ViewingArea

@Composable
fun NewPlan(modifier: Modifier = Modifier,
            navController: NavHostController
) {
    val pageCurrent: String = "NewPlan"
    var planTitle by rememberSaveable { mutableStateOf("Enter title here") }
    Scaffold(
        topBar = {
        },
        floatingActionButton = {
            OutlookPlannerFAB(pageCurrent = pageCurrent,navController = navController)
        },
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(it).fillMaxWidth()
        ) {
            ViewingArea(pageCurrent = pageCurrent)
            Text(text = "Title")
            TextField(value = planTitle, onValueChange = {null})
        }
    }
}