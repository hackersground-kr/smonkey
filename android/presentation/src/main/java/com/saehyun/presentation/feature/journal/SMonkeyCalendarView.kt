package com.saehyun.presentation.feature.journal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.common_kotlin.runIf
import com.saehyun.presentation.R
import com.saehyun.presentation.style.SmonkeyBody1
import com.saehyun.presentation.style.SmonkeyBody8
import com.saehyun.presentation.util.smonkeyClickable
import kotlinx.collections.immutable.ImmutableList
import java.time.LocalDate

@Composable
fun SMonkeyCalendarView(
    month: Int,
    year: Int,
    onMonthChanged: (Int) -> Unit,
    onYearChanged: (Int) -> Unit,
    quitSmokingDates: ImmutableList<Int>,
    smokingRelapseDates: ImmutableList<Int>
) {
    val daysInMonth = java.time.Month.of(month).length(java.time.Year.isLeap(year.toLong()))
    val firstDayOfWeek = LocalDate.of(year, month, 1).dayOfWeek.value % 7
    val weeks = ((firstDayOfWeek + daysInMonth - 1) / 7) + 1

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(24.dp)
                .smonkeyClickable {
                    if (month == 1) {
                        onYearChanged(year - 1)
                        onMonthChanged(12)
                    } else {
                        onMonthChanged(month - 1)
                    }
                },
            painter = painterResource(id = R.drawable.ic_arrow_left_24),
            contentDescription = null,
        )
        SmonkeyBody1(text = "${year}년 ${month}월")
        Image(
            modifier = Modifier
                .size(24.dp)
                .smonkeyClickable {
                    if (month == 12) {
                        onYearChanged(year + 1)
                        onMonthChanged(1)
                    } else {
                        onMonthChanged(month + 1)
                    }
                },
            painter = painterResource(id = R.drawable.ic_arrow_right_24),
            contentDescription = null,
        )
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items((weeks * 7)) { index ->
            val date = index - firstDayOfWeek + 1

            val isQuitSmoking = quitSmokingDates.contains(date)
            val isRelapseSmoking = smokingRelapseDates.contains(date)

            if ((index >= firstDayOfWeek) and (index < firstDayOfWeek + daysInMonth)) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .runIf(isQuitSmoking) {
                            background(
                                color = Color.Red,
                                shape = CircleShape,
                            )
                        }
                        .runIf(isRelapseSmoking) {
                            background(
                                color = Color.Blue,
                                shape = CircleShape,
                            )
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    SmonkeyBody8(text = date.toString())
                }
            } else {
                Spacer(Modifier.aspectRatio(1f))
            }
        }
    }
}
