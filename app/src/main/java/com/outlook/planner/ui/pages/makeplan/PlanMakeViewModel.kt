package com.outlook.planner.ui.pages.makeplan

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.outlook.planner.data.plan.Plan
import com.outlook.planner.data.plan.database.PlanRepository
import com.outlook.planner.data.plan.toEntity
import com.outlook.planner.data.plan.toMakePlanUiState
import com.outlook.planner.ui.navigation.destination.DestinationPlanMake
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class PlanMakeViewModel(
    savedStateHandle: SavedStateHandle,
    private val planRepository: PlanRepository,
): ViewModel() {
    /**
     * Make Plan UI state
     */
    var planMakeUiState by mutableStateOf(PlanMakeUiState())
        private set

    /**
     * Initialize private values in presence of an existing Plan object
     */
    init {
        try {
            val planId: Int = checkNotNull(savedStateHandle[DestinationPlanMake.PLAN_ID])
            viewModelScope.launch {
                planMakeUiState = planRepository
                    .getPlanOne(planId)
                    .filterNotNull()
                    .first()
                    .toMakePlanUiState()
            }
        } catch(_: Exception) {
            /**
             * No Plan ID supplied
             *
             * Assume user is making plan, or plan is missing in database
             */
        }
    }

    /**
     * Check that no fields are empty
     */
    private fun validateInput(planCheck: Plan = planMakeUiState.plan): Boolean {
        return with(planCheck) {
            note.isNotBlank()
        }
    }

    /**
     * Updates the [planMakeUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(planUpdated: Plan) {
        planMakeUiState = PlanMakeUiState(
            plan = planUpdated,
            fieldNotEmptyAll = validateInput(planUpdated)
        )
    }

    /**
     * Insert + Update current plan
     */
    suspend fun planUpsert() {
        if (validateInput()) planRepository.planUpsert(planMakeUiState.plan.toEntity())
    }
}