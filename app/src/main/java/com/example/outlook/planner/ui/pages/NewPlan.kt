package com.example.outlook.planner.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.outlook.planner.ui.components.OutlookPlannerFAB
import com.example.outlook.planner.ui.design.ViewingArea

@Composable
fun NewPlan(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // Immutable values
    val pageCurrent = "NewPlan"
    val heightSpacer = 16.dp
    val textStyle = TextStyle(textAlign = TextAlign.Center)


    var planTitle by rememberSaveable { mutableStateOf("") }
    var planDescription by rememberSaveable { mutableStateOf("") }
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
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
        ) {
            ViewingArea(pageCurrent = pageCurrent)

            /**
             * Title of plan
             */
            Text(text = "Title")
            TextField(
                value = planTitle,
                onValueChange = {newTitle:String -> planTitle = newTitle},
                textStyle = textStyle,
                placeholder = {
                    Text(
                        text = "Your title here",
                        textAlign = TextAlign.Center,
                    )
                },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(heightSpacer))
            /**
             * Description of plan
              */
            Text(text = "Description")
            TextField(
                value = planDescription,
                onValueChange = {newDescription:String -> planDescription = newDescription},
                textStyle = textStyle,
                placeholder = {
                    Text(
                        text = "Your description here",
                        textAlign = TextAlign.Center,
                    )
                }
            )
            Spacer(modifier = Modifier.height(heightSpacer))

            /**
             * Date & Time
             * https://medium.com/@segunfrancis/how-to-create-material-date-and-time-pickers-in-android-18ecd246838b
             */


        }
    }
}