package com.outlook.planner.ui.components

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.outlook.planner.data.plan.Plan
import com.outlook.planner.data.plan.PlanEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun PlanCard(
    modifier: Modifier = Modifier,
    planEntity: PlanEntity,
) {
    /**
     * Immutable values
     */
    val dateOfPlan: LocalDate = LocalDate.of(planEntity.year, planEntity.month, planEntity.date)
    val timeOfPlan: LocalTime = LocalTime.of(planEntity.hour, planEntity.minute)
    val dateTimeOfPlan: LocalDateTime = LocalDateTime.of(dateOfPlan, timeOfPlan)

    /**
     * Check if it happened yesterday, today or tomorrow
     */
    val timeToAddress: String = when(dateOfPlan) {

        LocalDate.now().minusDays(1) -> "Yesterday"
        LocalDate.now() -> "Today"
        LocalDate.now().plusDays(1) -> "Tomorrow"
        else -> when(dateOfPlan) {
            /**
             * Determine if it happened last week, this week or the next
             */
            LocalDate.now().minusWeeks(1) -> "Last week"
            LocalDate.now().plusWeeks(1) -> "Next week"
            else -> when(dateOfPlan.month) {
                /**
                 * Determine if it happened last month or the next
                 */
                LocalDate.now().minusMonths(1).month -> "Last Month"
                LocalDate.now().month -> "This Month"
                LocalDate.now().plusMonths(1).month -> "Next Month"
                else -> when(dateTimeOfPlan.year) {
                    /**
                     * Determine if it will happen last year, this year or the next
                     *
                     * NOTE:
                     * This will attempt to format each month into 3 letters as system locale
                     * Currently hardcoded to English, but hoping to make it dynamic
                     */
                    LocalDateTime.now().minusYears(1).year -> "Last Year"
                    LocalDateTime.now().year -> "${dateOfPlan.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)} ${dateOfPlan.dayOfMonth}"
                    LocalDateTime.now().plusYears(1).year -> "Last Year"
                    else -> "In ${dateOfPlan.year}"
                }
            }
        }
    }

    /**
     * Show time frame of the event
     */
    val informWhen = buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(timeToAddress)
        }
        append(" at ")
        append(timeOfPlan.toString())
    }

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
                text = informWhen,
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
                        text = planEntity.note,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
        }
    }
}