package com.outlook.planner.ui.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.outlook.planner.data.plan.PlanEntity
import com.outlook.planner.data.plan.database.PlanRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * ViewModel to retrieve all items in the Room database.
 */
class HomeViewModel(val planRepository: PlanRepository): ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> =
        planRepository.getPlanAll().map { listPlanEntity -> HomeUiState(listPlanEntity) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )
    /**
     * Delete current plan
     */
    suspend fun planDelete(planEntity: PlanEntity) {
        planRepository.planDelete(planEntity)
    }
}