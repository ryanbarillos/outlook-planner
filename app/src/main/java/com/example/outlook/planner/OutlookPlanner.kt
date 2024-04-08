package com.example.outlook.planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.outlook.planner.ui.pages.Home
import com.example.outlook.planner.ui.plan.MakePlan
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
    NavHost(
        navController = navController,
        startDestination = OutlookPlannerScreen.Home.name,
        modifier = modifier
    ) {
        composable(route = OutlookPlannerScreen.Home.name) {
            Home(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                navController = navController
            )
        }
        composable(route = OutlookPlannerScreen.MakePlan.name) {
            val context = LocalContext.current
            MakePlan(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                navController = navController
            )
        }
    }
//    NewPlan(Modifier.padding(8.dp))
//    Home(Modifier.padding(8.dp))



//    Scaffold (
//        topBar = {
//            OutlookPlannerTopBar()
//        },
//        floatingActionButton = {
//            OutlookPlannerFAB
//        }
//    ) {
//        LazyColumn (modifier = Modifier.padding(it)) {
//            /**
//             * Weather Status
//             */
//            item {
//                OutlookPlannerWeatherStatus()
//            }
//            item {
//                Spacer(modifier = Modifier.height(48.dp))
//            }
//            items(1024) {
//                OutlookPlannerCard(modifier = Modifier.padding(16.dp))
//            }
//        }
//    }
}

@Composable
fun OutlookPlannerWeatherStatus(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Hey! Today Is",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 32.sp
        )
        Text(
            text = "-7",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = (72).sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Mostly Cloudy",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 24.sp
        )
    }
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
