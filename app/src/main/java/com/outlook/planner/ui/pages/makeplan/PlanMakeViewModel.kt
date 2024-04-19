package com.outlook.planner.ui.pages.makeplan

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.outlook.planner.data.plan.Plan
import com.outlook.planner.data.plan.PlanEntity
import com.outlook.planner.data.plan.database.PlanRepository
import com.outlook.planner.data.plan.toEntity
import com.outlook.planner.data.plan.toPlan
import kotlinx.coroutines.flow.filterNotNull


class PlanMakeViewModel(
    savedStateHandle: SavedStateHandle? = null,
    private val planRepository: PlanRepository
): ViewModel() {
    /**
     * Make Plan UI state
     */
    var planMakeUiState: PlanMakeUiState by mutableStateOf(PlanMakeUiState())
        private set

    /**
     * Initialize private values in presence of an existing Plan object
     */
    suspend fun initialize(id: Int) {
        planRepository
            .getPlanOne(id)
            .filterNotNull()
            .collect { planEntity -> planMakeUiState.copy(plan = planEntity.toPlan()) }
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
//        Log.d("ADebugTag", "Value: ${makePlanUiState.plan.note}")
    }

    /**
     * Insert + Update current plan
     */
    suspend fun planUpsert() {
        if (validateInput()) {
            planRepository.planUpsert(planMakeUiState.plan.toEntity())
        }
    }
}