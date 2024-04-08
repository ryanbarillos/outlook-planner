package com.example.outlook.planner.ui.plan

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MakePlanViewModel: ViewModel() {
    // Make Plan UI state
    private val _uiState = MutableStateFlow(MakePlanUiState())
    val uiState: StateFlow<MakePlanUiState> = _uiState.asStateFlow()

    // Backing property to avoid state updates from other classes



}