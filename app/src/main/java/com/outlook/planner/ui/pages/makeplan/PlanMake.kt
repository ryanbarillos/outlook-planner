package com.outlook.planner.ui.pages.makeplan

import android.content.Context
import android.text.format.DateFormat.is24HourFormat
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.outlook.planner.R
import com.outlook.planner.data.plan.Plan
import com.outlook.planner.ui.AppViewModelProvider
import com.outlook.planner.ui.components.AppFAB
import com.outlook.planner.ui.components.picker.PickerDate
import com.outlook.planner.ui.components.picker.PickerTime
import com.outlook.planner.ui.design.ViewingArea
import com.outlook.planner.ui.navigation.destination.DestinationPlanMake
import com.google.android.material.timepicker.MaterialTimePicker
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.TimeZone

@Composable
fun PlanMake(
    modifier: Modifier = Modifier,
    pageCurrent: String,
    navigateBack: () -> Unit,
    canNavigateBack: Boolean = true,
    context: Context = LocalContext.current,
    plan: Plan? = null,
    viewModel: PlanMakeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    /**
     * Immutable values
     */
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
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
                planMakeUiState = viewModel.planMakeUiState,
                onPlanValueChange = viewModel::updateUiState,
                context = context
            )
        }
    }
}


/**
 * References:
 * https://codingwithrashid.com/how-to-add-underlined-text-in-android-jetpack-compose/
 */
@Composable
fun MakePlanBody(
    modifier: Modifier = Modifier,
    planMakeUiState: PlanMakeUiState,
    onPlanValueChange: (Plan) -> Unit,
    context: Context
) {
    /**
     * Encompass the Plan in the UI state to a concise pointer variable
     */
    val plan: Plan = planMakeUiState.plan

    /**
     * Embellishment values
     */
    val heightSpacer: Dp = 32.dp
    val heightSpacerBetweenTextAndButton: Dp = 8.dp
    val textStyle = TextStyle(textAlign = TextAlign.Left)
    val sizeFontOfHeader = 16.sp
    val sizeFontOfDateTimeValue = 24.sp

    /**
     * Logic variables
     */
    var showPickerTime: Boolean by remember { mutableStateOf(false) }
    var showPickerDate: Boolean by remember { mutableStateOf(false) }

    /**
     * Display variables
     */
    var displayTime: LocalTime by remember { mutableStateOf(LocalTime.of(plan.hour, plan.minute)) }
    var displayDate: LocalDate by remember { mutableStateOf(LocalDate.of(plan.year, plan.month, plan.date)) }

    /**
     * Field to insert a note
     */
    Text(
        text = "Note",
        fontSize = sizeFontOfHeader
    )
    TextField(
        value = planMakeUiState.plan.note,
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
     * Field to pick a time
     */
    Text(
        text = stringResource(id = R.string.ask_time),
        fontSize = sizeFontOfHeader
    )
    Spacer(modifier = Modifier.height(heightSpacerBetweenTextAndButton))
    Text(
        text = buildAnnotatedString {
            append("On")
            append(" ")
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append(displayTime.toString())
            }
        },
        fontSize = sizeFontOfDateTimeValue,
    )
    Spacer(modifier = Modifier.height(heightSpacerBetweenTextAndButton))
    Button(
        onClick = { showPickerTime = !showPickerTime },
    ) {
        Text(
            text = stringResource(id = R.string.set_time)
        )
        if(showPickerTime) {
            ShowMaterialDateTimePicker(
                context = context,
                typeReturn = TYPE_TIME,
                onDateTimeSet = {
                    newTime -> onPlanValueChange(plan.copy(hour = newTime.hour, minute = newTime.minute))
                }
            )
            showPickerTime = !showPickerTime
        }
        // Update the time to show on UI screen
        displayTime = LocalTime.of(plan.hour, plan.minute)
    }
    Spacer(modifier = Modifier.height(heightSpacer))

    /**
     * Field to pick a date
     */
    Text(
        text = stringResource(id = R.string.ask_date),
        fontSize = sizeFontOfHeader
    )
    Spacer(modifier = Modifier.height(heightSpacerBetweenTextAndButton))
    Text(
        text = when(displayDate) {
            LocalDate.now() -> "Today!"
            LocalDate.now().plusDays(1) -> "Tomorrow!"
            else -> "${displayDate.dayOfMonth} ${displayDate.month} ${displayDate.year}"
        },
        fontSize = sizeFontOfDateTimeValue,
    )
    Spacer(modifier = Modifier.height(heightSpacerBetweenTextAndButton))
    Button(
        onClick = { showPickerDate = !showPickerDate },
    ) {
        Text(
            text = stringResource(id = R.string.set_date)
        )
        if(showPickerDate) {
            ShowMaterialDateTimePicker(
                typeReturn = TYPE_DATE,
                onDateTimeSet = {newDate -> onPlanValueChange(plan.copy(date = newDate.dayOfMonth, month = newDate.monthValue, year = newDate.year))
                }
            )
            showPickerDate = !showPickerDate
        }
        // Update the [displayDate] to show on UI screen display
        displayDate = LocalDate.of(plan.year, plan.month, plan.date)
    }
}


@Composable
fun ShowMaterialDateTimePicker(
    context: Context? = null,
    typeReturn: String,
    onDateTimeSet: (LocalDateTime) -> Unit
) {
    /**
     * Shared variables among the dialogs
     */
    var pickedDateTime: LocalDateTime = LocalDateTime.now()

    /**
     * Check if user wants date or time
     */
    when(typeReturn) {
        /**
         * RETURN:
         * Time in Hours & Minutes
         *
         * Build the MaterialTimePicker Dialog
         */
        TYPE_TIME -> {
            val pickerTime = PickerTime(
                modeInput = MaterialTimePicker.INPUT_MODE_CLOCK,
                title = "Set a Time",
                setClockFormat = is24HourFormat(context)
            ).dialog

            /**
             * Show it
             */
            pickerTime.show(
                getActivity().supportFragmentManager,
                DestinationPlanMake.route
            )
            /**
             * Save its values
             */
            pickerTime.addOnPositiveButtonClickListener {
                /**
                 * Convert the chosen time to Java's new API called "LocalDateTime"
                 * then pass two arguments to it to be made:
                 * - date = LocalDateTime.now().toLocalDate()
                 * - time = Picked time of user
                 */
                pickedDateTime = LocalDateTime.of(
                    LocalDateTime.now().toLocalDate(),
                    LocalTime.of(pickerTime.hour, pickerTime.minute)
                )
                /**
                 * And then we return that value
                 */
                Log.d("ADebug", "Picked time is now ${pickedDateTime.toLocalTime()}")
                onDateTimeSet(pickedDateTime)
            }
        }
        /**
         * RETURN:
         * Date in Year, Month, Date
         *
         * Build the MaterialDatePicker Dialog
         */
        TYPE_DATE -> {
            val pickerDate = PickerDate(title = stringResource(id = R.string.set_date)).dialog

            /**
             * Show it
             */
            pickerDate.show(
                getActivity().supportFragmentManager,
                DestinationPlanMake.route
            )
            /**
             * Save its values
             */
            pickerDate.addOnPositiveButtonClickListener { dateInLong ->
                /**
                 * Convert the chosen date to Java's new API called "LocalDateTime"
                 * then pass two arguments to it to be made:
                 * - date = Conversion of user's picked date from long (default type) to a date
                 * - time = Picked time of user
                 *
                 * NOTE:
                 * By default, this returns the date yesterday, so
                 * use plusDays() or UTC timezone to correct that
                 *
                 * - https://stackoverflow.com/a/7672633
                 */
//                pickedDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateInLong), TimeZone.getDefault().toZoneId())
                pickedDateTime = Instant.ofEpochMilli(dateInLong).atZone(ZoneId.of("UTC")).toLocalDateTime()


                /**
                 * And then we return that value
                 */
                Log.d("ADebug", "What is ${pickedDateTime.dayOfMonth} ${pickedDateTime.monthValue} ${pickedDateTime.year} to you?")
                Log.d("ADebug", "Correct date should be ${LocalDateTime.now().toLocalDate()} to you?")
                Log.d("ADebug", "Timezone is ${TimeZone.getDefault()}\n vs. ${TimeZone.getTimeZone("UTC")} to you?")
//                Log.d("ADebug", "What is $selectedDate to you?")
                onDateTimeSet(pickedDateTime)
            }
        }
        else -> {
            /**
             * Neither was specified,
             * so return a generic answer: Today
             */
            onDateTimeSet(pickedDateTime)
        }
    }


}
