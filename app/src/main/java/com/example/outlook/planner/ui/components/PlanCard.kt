package com.example.outlook.planner.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.outlook.planner.data.plan.PlanEntity
import java.time.LocalDate

@Composable
fun PlanCard(
    modifier: Modifier = Modifier,
    planEntity: PlanEntity
) {
    /**
     * Immutable values
     */
    val dateOfPlan: LocalDate = LocalDate.of(planEntity.year, planEntity.month, planEntity.date)
    val timeToAddress: String = when(dateOfPlan) {
        /**
         * Check if it happened yesterday, today or tomorrow
         */
        LocalDate.now().minusDays(1) -> "Yesterday"
        LocalDate.now() -> "Today"
        LocalDate.now().plusDays(1) -> "Tomorrow"
        else -> when(dateOfPlan) {
            /**
             * Determine if it happened last week, this week or the next
             */
            LocalDate.now().minusWeeks(1) -> "Last week"
            LocalDate.now().plusWeeks(1) -> "Next week"
            else -> "O no"
        }
    }
    Log.d("ADebug", "$dateOfPlan is equal to ${LocalDate.now()}")
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
        defaultElevation = 6.dp,
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = "$timeToAddress on ${
                    when(planEntity.hour) {
                        in 0..9 -> "0${planEntity.hour}"
                        else -> "${planEntity.hour}"
                    }
                }:${
                    when(planEntity.minute) {
                        in 0..9 -> "0${planEntity.minute}"
                        else -> "${planEntity.minute}"
                    }
                }",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 64.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = planEntity.note.ifEmpty { "Meet up with NoobMaster69" },
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
        }
    }
}