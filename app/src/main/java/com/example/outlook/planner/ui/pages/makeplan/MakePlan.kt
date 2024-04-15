package com.example.outlook.planner.ui.pages.makeplan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.outlook.planner.data.plan.Plan
import com.example.outlook.planner.ui.AppViewModelProvider
import com.example.outlook.planner.ui.components.OutlookPlannerFAB
import com.example.outlook.planner.ui.design.ViewingArea
import kotlinx.coroutines.launch

@Composable
fun MakePlan(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MakePlanViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    /**
     * Immutable values
     */
    val pageCurrent = "MakePlan"
    val heightSpacer = 16.dp
    val textStyle = TextStyle(textAlign = TextAlign.Left)
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
        },
        floatingActionButton = {
            OutlookPlannerFAB(
                pageCurrent = pageCurrent,
                navController = navController
            )
        },
        modifier = modifier
    ) {innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            ViewingArea(pageCurrent = pageCurrent)

            /**
             * Note of plan
             */
//            MakePlanBody(
//                makePlanUiState = viewModel.makePlanUiState,
//                onPlanValueChange = viewModel::updateUiState,
//                onSaveClick = {
//                    coroutineScope.launch {
//                        viewModel.savePlan()
//                    }
//                },
//                modifier = modifier
//            )
        }
    }
}

@Composable
fun MakePlanBody(
    makePlanUiState: MakePlanUiState,
    onPlanValueChange: (Plan) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(text = "Note")
//    TextField(
//        value = makePlanViewModel.getNote(),
//        onValueChange = { newNote -> makePlanViewModel.setNote(newNote) },
//        textStyle = textStyle,
//        placeholder = {
//            Text(
//                text = "Your note here",
//                textAlign = TextAlign.Center,
//            )
//        }
//    )
//    Spacer(modifier = Modifier.height(heightSpacer))
//    /**
//     * Date & Time
//     * https://medium.com/@segunfrancis/how-to-create-material-date-and-time-pickers-in-android-18ecd246838b
//     */
}