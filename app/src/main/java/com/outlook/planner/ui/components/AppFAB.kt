package com.outlook.planner.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.outlook.planner.R
import com.outlook.planner.ui.navigation.destination.DestinationPlanEdit
import com.outlook.planner.ui.navigation.destination.DestinationPlanMake

@Composable
fun AppFAB(
    pageCurrent: String,
    onClick: () -> Unit = {}

    ) {
    when(pageCurrent) {
        /**
         * Current page is Make PLan
         */
        DestinationPlanMake.route -> {
            ExtendedFloatingActionButton(
                onClick = onClick,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "Create plan button."
                    )
                },
                text = {
                    Text(text = stringResource(id = R.string.name_plan_make))
                },
            )
        }
        /**
         * Current page is Edit PLan
         */
        DestinationPlanEdit.route -> {
            ExtendedFloatingActionButton(
                onClick = onClick,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit plan button."
                    )
                },
                text = {
                    Text(text = stringResource(id = R.string.name_plan_edit))
                },
            )
        }
        /**
         * current page is Home
         */
        else -> {
            ExtendedFloatingActionButton(
                onClick = onClick,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add plan button."
                    )
                },
                text = {
                    Text(text = "New Plan")
                }
            )
        }
    }
}