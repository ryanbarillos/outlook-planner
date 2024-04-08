package com.example.outlook.planner.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * [OPViewModel]
 *
 * It holds information about either a new plan, or an existing one
 * All temporary info of a plan is stored here until the transaction
 * is complete to be sent to the database of plans
 */
class OPViewModel: ViewModel() {

    /**
     * For [OPUiState]
     */
    private val _uiState = MutableStateFlow(OPUiState())
    val uiState: StateFlow<OPUiState> = _uiState.asStateFlow()

    private lateinit var idk: String

    val currentTitle = ""
    val currentDescription = ""
}