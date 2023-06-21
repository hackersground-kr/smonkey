package com.saehyun.presentation.feature.journal

import android.widget.CalendarView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saehyun.common_kotlin.runIf
import com.saehyun.domain.Writer
import com.saehyun.presentation.R
import com.saehyun.presentation.component.BigTopAppBar
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.component.toSmonkeyCharacter
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody1
import com.saehyun.presentation.style.SmonkeyBody10
import com.saehyun.presentation.style.SmonkeyBody5
import com.saehyun.presentation.style.SmonkeyBody7
import com.saehyun.presentation.style.SmonkeyBody8
import com.saehyun.presentation.style.SmonkeyBody9
import com.saehyun.presentation.util.smonkeyClickable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.jetbrains.annotations.Async
import org.orbitmvi.orbit.compose.collectSideEffect
import java.time.LocalDate

@Composable
fun JournalScreen(
    modifier: Modifier = Modifier,
    vm: JournalViewModel,
) {
    val state = vm.container.stateFlow.collectAsState().value

    LaunchedEffect(key1 = vm) {
        fun handleSideEffect(sideEffect: JournalSideEffect) {

        }

        vm.container.sideEffectFlow
            .onEach(::handleSideEffect)
            .launchIn(this)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SMonkeyColor.Gray200),
    ) {
        BigTopAppBar(
            leadingContent = { SmonkeyBody1(text = "일지") },
            trailingContent = {
                Image(
                    painter = painterResource(id = R.drawable.ic_pen_green_24),
                    contentDescription = null,
                )
            },
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(space = 24.dp)
            SMonkeyCalendarView(
                month = state.journalMonth,
                year = state.journalYear,
                quitSmokingDates = state.quitSmokingDates,
                smokingRelapseDates = state.smokingRelapseDates,
                onMonthChanged = { month ->
                    vm.updateMonth(month)
                },
                onYearChanged = { year ->
                    vm.updateYear(year)
                }
            )
            Spacer(space = 57.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(weight = 1f)
                SmonkeyBody10(text = "금연 성공일")
                Spacer(space = 8.dp)
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .background(
                            color = Color.Blue,
                            shape = CircleShape,
                        )
                )
                Spacer(space = 14.dp)
                SmonkeyBody10(text = "금연 실패일")
                Spacer(space = 4.dp)
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = Color.Red,
                            shape = CircleShape,
                        )
                )
            }
        }
    }
}

