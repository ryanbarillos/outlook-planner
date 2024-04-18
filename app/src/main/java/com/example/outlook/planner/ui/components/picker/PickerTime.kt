package com.example.outlook.planner.ui.components.picker

import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class PickerTime(
    modeInput: Int,
    title: String,
    setClockFormat: Boolean
) {
    /**
     * Reference(s):
     * - https://medium.com/@segunfrancis/how-to-create-material-date-and-time-pickers-in-android-18ecd246838b
     * - https://medium.com/@mdhsieh8/showing-materialtimepicker-and-materialdatepicker-7f417a6b978e
     * - https://github.com/mdhsieh/example-material-picker
     */

    /**
     * Determine if system clock format is 12 hours or 24 hours
     */
    private val clockFormat = if (setClockFormat) {
        TimeFormat.CLOCK_24H
    } else {
        TimeFormat.CLOCK_12H
    }

    /**
     * Material Time Picker Builder
     */
    val dialog = MaterialTimePicker.Builder()
        .setTimeFormat(clockFormat)
        .setHour(12)
        .setMinute(0)
        .setInputMode(modeInput)
        .setTitleText(title)
        .build()
}

