package com.outlook.planner.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.outlook.planner.OutlookPlannerApplication
import com.outlook.planner.ui.pages.home.HomeViewModel
import com.outlook.planner.ui.pages.makeplan.PlanMakeViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Outlook Planner app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        /**
         * Initializer for [PlanMakeViewModel]
         */
        initializer {
            PlanMakeViewModel(
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