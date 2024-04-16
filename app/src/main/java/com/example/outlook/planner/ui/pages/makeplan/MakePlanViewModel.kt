package com.example.outlook.planner.ui.pages.makeplan

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.outlook.planner.data.plan.Plan
import com.example.outlook.planner.data.plan.PlanEntity
import com.example.outlook.planner.data.plan.database.PlanRepository
import com.example.outlook.planner.data.plan.toEntity


class MakePlanViewModel(
    savedStateHandle: SavedStateHandle? = null,
    private val planRepository: PlanRepository
): ViewModel() {
    /**
     * Make Plan UI state
     */
    var makePlanUiState by mutableStateOf(MakePlanUiState())
        private set

    /**
     * Initialize private values in presence of an existing Plan object
     */
    fun initialize(planEntity: PlanEntity) {
        /** DO SOMETHING */
    }
//    init {
//        if (savedStateHandle != null) {
//            viewModelScope.launch {
//                makePlanUiState = planRepository.getPlanOne(planId)
//                    .filterNotNull()
//                    .first()
//                    .toItemUiState(true)
//            }
//        }
//    }


    /**
     * Check that no fields are empty
     */
    private fun validateInput(planCheck: Plan = makePlanUiState.plan): Boolean {
        return with(planCheck) {
            note.isNotBlank()
        }
    }

    /**
     * Updates the [makePlanUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(planUpdated: Plan) {
        makePlanUiState = MakePlanUiState(
            plan = planUpdated,
            fieldNotEmptyAll = validateInput(planUpdated)
        )
    }

    /**
     * Insert + Update current plan
     */
    suspend fun planUpsert() {
        if (validateInput()) {
            planRepository.planUpsert(makePlanUiState.plan.toEntity())
        }
    }
}