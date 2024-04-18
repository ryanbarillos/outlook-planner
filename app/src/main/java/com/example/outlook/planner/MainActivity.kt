package com.example.outlook.planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.outlook.planner.ui.theme.OutlookPlannerTheme


/**
 * Extend AppCompatActivity instead of ComponentActivity.
 * AppCompatActivity extends FragmentActivity which extends ComponentActivity.
 *
 * REQUIRED BY MaterialTimePicker(), which is used in [MakePlan.kt]
 */
//class MainActivity : ComponentActivity() {
class MainActivity : AppCompatActivity() {
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
