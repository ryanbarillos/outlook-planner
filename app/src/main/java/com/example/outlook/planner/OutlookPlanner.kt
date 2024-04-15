package com.example.outlook.planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.outlook.planner.ui.navigation.OutlookPlannerNavHost
import com.example.outlook.planner.ui.theme.OutlookPlannerTheme


class OutlookPlanner : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            OutlookPlannerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OutlookPlannerApp()
                }
            }
        }
    }
}


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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OutlookPlannerTheme(darkTheme = false) {
        OutlookPlannerApp()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreviewDark() {
    OutlookPlannerTheme(darkTheme = true) {
        OutlookPlannerApp()
    }
}
