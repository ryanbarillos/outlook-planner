package com.example.outlook.planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.outlook.planner.ui.OutlookPlannerBottomBar
import com.example.outlook.planner.ui.OutlookPlannerCard
import com.example.outlook.planner.ui.OutlookPlannerTopBar
import com.example.outlook.planner.ui.theme.OutlookPlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
fun yea(modifier: Modifier = Modifier): List<Unit> {
    return listOf(
        OutlookPlannerCard(modifier = Modifier.padding(16.dp)),
        OutlookPlannerCard(modifier = Modifier.padding(16.dp)),
        OutlookPlannerCard(modifier = Modifier.padding(16.dp)),
        OutlookPlannerCard(modifier = Modifier.padding(16.dp))
    )
}

@Composable
fun OutlookPlannerApp(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
            OutlookPlannerTopBar()
        },
        floatingActionButton = {
            OutlookPlannerBottomBar()
        }
    ) {
        LazyColumn (modifier = Modifier.padding(it)) {
            /**
             * Weather Status
             */
            item {
                OutlookPlannerWeatherStatus()
            }
            item {
                Spacer(modifier = Modifier.height(48.dp))
            }
            items(1024) {
                OutlookPlannerCard(modifier = Modifier.padding(16.dp))
            }
        }
    }
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
    OutlookPlannerTheme {
        OutlookPlannerApp()
    }
}