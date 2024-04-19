package com.outlook.planner.ui.components.picker

import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker

class PickerDate(
    title: String
) {
    /**
     * Material Date Picker Builder
     *
     * Reference(s):
     * - https://github.com/material-components/material-components-android/blob/master/docs/components/DatePicker.md
     * - https://medium.com/@segunfrancis/how-to-create-material-date-and-time-pickers-in-android-18ecd246838b
     * - https://github.com/material-components/material-components-android/blob/master/docs/components/DatePicker.md#adding-calendar-constraints
     * - https://www.geeksforgeeks.org/more-functionalities-of-material-design-date-picker-in-android/
     * - https://medium.com/@mrizqi070502/quick-and-easy-a-basic-guide-to-implementing-date-picker-in-android-114b36394953
     *
     * NOTE:
     * by default, setSelection() is set to pick the date today
     */
    // Limit selectable dates to starting today
    private val constraints =
        CalendarConstraints.Builder()
            .setValidator(DateValidatorPointForward.now())
            .build()

    // Then apply those limits to the MaterialDatePicker
    val dialog = MaterialDatePicker.Builder.datePicker()
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .setTitleText(title)
        .setCalendarConstraints(constraints)
        .build()
}