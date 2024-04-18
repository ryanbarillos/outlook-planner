package com.example.outlook.planner.ui.pages.makeplan

import android.content.Context
import android.os.Build
import android.text.format.DateFormat.is24HourFormat
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.outlook.planner.R
import com.example.outlook.planner.data.plan.Plan
import com.example.outlook.planner.ui.AppViewModelProvider
import com.example.outlook.planner.ui.components.AppFAB
import com.example.outlook.planner.ui.components.picker.PickerTime
import com.example.outlook.planner.ui.design.ViewingArea
import com.example.outlook.planner.ui.navigation.destination.DestinationMakePlan
import com.google.android.material.timepicker.MaterialTimePicker
import kotlinx.coroutines.launch
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MakePlan(
    modifier: Modifier = Modifier,
    pageCurrent: String,
    navigateBack: () -> Unit,
    canNavigateBack: Boolean = true,
    context: Context = LocalContext.current,
    viewModel: MakePlanViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    /**
     * Immutable values
     */
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
        },
        floatingActionButton = {
            AppFAB(
                pageCurrent = pageCurrent,
                onClick = {
                    coroutineScope.launch {
                        viewModel.planUpsert()
                        navigateBack()
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
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
            MakePlanBody(
                modifier = modifier,
                makePlanUiState = viewModel.makePlanUiState,
                onPlanValueChange = viewModel::updateUiState,
                context = context
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakePlanBody(
    modifier: Modifier = Modifier,
    makePlanUiState: MakePlanUiState,
    onPlanValueChange: (Plan) -> Unit,
    context: Context
) {
    /**
     * Encompass the Plan in the UI state to a concise pointer variable
     */
    val plan: Plan = makePlanUiState.plan

    /**
     * Embellishment values
     */
    val heightSpacer: Dp = 32.dp
    val heightSpacerBetweenTextAndButton: Dp = 8.dp
    val textStyle = TextStyle(textAlign = TextAlign.Left)
    val sizeFontOfDateTime = 24.sp

    /**
     * Logic variables
     */
    var showPickerTime: Boolean by remember { mutableStateOf(false) }
    var showPickerDate: Boolean by remember { mutableStateOf(false) }

    /**
     * Display variables
     */
    var showTime: String by remember { mutableStateOf(value = "What Time?") }


    /**
     * Note field
     */
    Text(text = "Note")
    TextField(
        value = makePlanUiState.plan.note,
        onValueChange = { noteNew -> onPlanValueChange(plan.copy(note = noteNew)) },
        textStyle = textStyle,
        placeholder = {
            Text(
                text = "Your note here",
                textAlign = TextAlign.Center,
            )
        }
    )
    Spacer(modifier = Modifier.height(heightSpacer))
    /**
     * Date & Time dialog pickers
     *
     * Reference(s):
     *
     * - https://medium.com/@segunfrancis/how-to-create-material-date-and-time-pickers-in-android-18ecd246838b
     * - https://medium.com/@mrizqi070502/quick-and-easy-a-basic-guide-to-implementing-date-picker-in-android-114b36394953
     * - https://medium.com/@mdhsieh8/showing-materialtimepicker-and-materialdatepicker-7f417a6b978e
     * - https://github.com/mdhsieh/example-material-picker
     */
    Text(
        text = showTime,
        fontSize = sizeFontOfDateTime,
    )
    Spacer(modifier = Modifier.height(heightSpacerBetweenTextAndButton))
    Button(
        onClick = { showPickerTime = !showPickerTime },
    ) {
        Text(
            text = stringResource(id = R.string.set_time)
        )
    }
    if(showPickerTime) {
        ShowMaterialTimePicker(
            context = context,
            onTimeSet = {
                newTime -> onPlanValueChange(plan.copy(hour = newTime.hour, minute = newTime.minute));

            }
        )
        showTime = "On ${
            when(plan.hour) {
                in 0..9 -> "0${plan.hour}"
                else -> "${plan.hour}"
            }
        }:${
            when(plan.minute) {
                in 0..9 -> "0${plan.minute}"
                else -> "${plan.minute}"
            }
        }"
        showPickerTime = false;
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowMaterialTimePicker(
    context: Context,
    onTimeSet: (LocalTime) -> Unit
) {
    /**
     * Build the MaterialTimePicker
     */
    val pickerTime = PickerTime(
        modeInput = MaterialTimePicker.INPUT_MODE_CLOCK,
        title = "Set a Time",
        setClockFormat = is24HourFormat(context)
    )
    /**
     * Show it
     */
    pickerTime.dialog.show(
        getActivity().supportFragmentManager,
        DestinationMakePlan.route
    )
    /**
     * Save its values
     */
    pickerTime.dialog.addOnPositiveButtonClickListener {
        // Gets LocalTime object from the chosen time
        val selectedTime = LocalTime.of(pickerTime.dialog.hour, pickerTime.dialog.minute)

        //Then returns that value
        onTimeSet(selectedTime)
    }
}