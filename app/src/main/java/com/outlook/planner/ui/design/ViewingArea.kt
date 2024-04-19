package com.outlook.planner.ui.design

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.outlook.planner.ui.navigation.destination.DestinationPlanMake

/**
 * According to Samsung's One UI Design Guidelines:
 * "(The viewing area is the) place (for) content that
 * doesn’t require any user interactions,such as a title."
 *
 * -- Pp. 6
 */
@Composable
fun ViewingArea(pageCurrent: String = "main") {
    val fontOfHeadline: TextUnit = 64.sp
    val gap: Dp = 48.dp
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        when(pageCurrent) {
            DestinationPlanMake.route -> {
                Text(
                    text = "Make Plan",
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = fontOfHeadline,
                    fontWeight = FontWeight.Light
                )
            }
            DestinationPlanMake.routeWithId -> {
                Text(
                    text = "Edit Plan",
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = fontOfHeadline,
                    fontWeight = FontWeight.Light
                )
            }
            else -> {
                Text(
                    text = "Hey! Today Is",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 32.sp
                )
                Text(
                    text = "-7",
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = fontOfHeadline,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Mostly Cloudy",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(gap))
    }
}