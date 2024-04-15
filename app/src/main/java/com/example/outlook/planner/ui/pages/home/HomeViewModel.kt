package com.example.outlook.planner.ui.pages.home

import androidx.lifecycle.ViewModel

/**
 * ViewModel to retrieve all items in the Room database.
 */
class HomeViewModel:ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}