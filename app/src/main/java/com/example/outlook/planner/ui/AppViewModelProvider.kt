package com.example.outlook.planner.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.outlook.planner.OutlookPlannerApplication
import com.example.outlook.planner.ui.pages.home.HomeViewModel
import com.example.outlook.planner.ui.pages.makeplan.MakePlanViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Outlook Planner app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        /**
         * Initializer for [MakePlanViewModel]
         */
        initializer {
            MakePlanViewModel(
                planRepository = outlookPlannerApplication().container.planRepository
            )
//            MakePlanViewModel()
        }

        /**
         * Initializer for [HomeViewModel]
         */
        initializer {
            HomeViewModel(
                planRepository = outlookPlannerApplication().container.planRepository
            )
        }
    }
}
/**
 * Extension function to queries for [Application] object and returns an instance of
 * [OutlookPlannerApplication].
 */
fun CreationExtras.outlookPlannerApplication(): OutlookPlannerApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as OutlookPlannerApplication)