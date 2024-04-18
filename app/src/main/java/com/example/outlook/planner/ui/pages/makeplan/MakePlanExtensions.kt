package com.example.outlook.planner.ui.pages.makeplan

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Function that only serves to retrieve a FragmentManager value
 * for one of the parameters needed to show a MaterialTimePicker
 * dialog
 */
@Composable
fun getActivity(): AppCompatActivity {
    val context = LocalContext.current
    return context as AppCompatActivity
}

const val TYPE_TIME = "time"
const val TYPE_DATE = "date"