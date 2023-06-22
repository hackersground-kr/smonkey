@file:OptIn(ExperimentalMaterial3Api::class)

package com.saehyun.presentation.feature.signup

import android.annotation.SuppressLint
import android.widget.DatePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.saehyun.common_kotlin.currentDate
import com.saehyun.common_kotlin.formatString
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.SmonkeyTextFieldButton
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.style.SmonkeyBody3
import com.saehyun.presentation.style.SmonkeyBody4
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

@Composable
fun SignUpFifthScreen(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    avgDailySmokeCount: String,
    updateAvgDailySmokeCount: (String) -> Unit,
    price: String,
    updatePrice: (String) -> Unit,
    updateSmokingStartAt: (Date) -> Unit,
    updateQuitSmokingStartAt: (Date) -> Unit,
    smokePerPack: String,
    updateSmokePerPack: (String) -> Unit,
) {

    val openDialog = remember { mutableStateOf(false) }
    val dialogType = remember { mutableStateOf(0) }

    val tempDate00 = remember { mutableStateOf<Date?>(null) }
    val tempDate01 = remember { mutableStateOf<Date?>(null) }

    if (openDialog.value) {
        val datePickerState = rememberDatePickerState()
        val confirmEnabled =
            remember { derivedStateOf { datePickerState.selectedDateMillis != null } }
        DatePickerDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        val date = datePickerState.selectedDateMillis?.let { Date(it) }

                        when (dialogType.value) {
                            0 -> {
                                tempDate00.value = date ?: Date()
                                updateSmokingStartAt(date ?: Date())
                            }

                            1 -> {
                                tempDate01.value = date ?: Date()
                                updateQuitSmokingStartAt(date ?: Date())
                            }
                        }
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    BaseProfileScreen(
        onPrevious = onPrevious,
        onNext = onNext,
        title = "프로필",
        index = 4,
        maxIndex = 5
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(space = 70.dp)
            SmonkeyBody4(
                text = "진짜 얼마 안남았어요!",
                align = TextAlign.Center,
            )
            SmonkeyBody3(
                text = "흡연, 금연을 언제 시작하셨나요?",
                align = TextAlign.Center,
            )
            Spacer(space = 92.dp)
            SMonkeyTextField(
                value = avgDailySmokeCount,
                onValueChange = updateAvgDailySmokeCount,
                hint = "평균 하루 흡연량 (개피)",
            )
            Spacer(space = 16.dp)
            SMonkeyTextField(
                value = price,
                onValueChange = updatePrice,
                hint = "담배가격",
            )
            Spacer(space = 16.dp)
            SmonkeyTextFieldButton(
                text = tempDate00.value?.formatString() ?: "흡연 시작일",
                enabled = true,
            ) {
                dialogType.value = 0
                openDialog.value = true
            }
            Spacer(space = 16.dp)
            SmonkeyTextFieldButton(
                text = tempDate01.value?.formatString() ?: "금연 시작일",
                enabled = true,
            ) {
                dialogType.value = 1
                openDialog.value = true
            }
            Spacer(space = 16.dp)
            SMonkeyTextField(
                value = smokePerPack,
                onValueChange = updateSmokePerPack,
                hint = "담배 한 갑 개비 수",
            )
            Spacer(space = 70.dp)
        }
    }
}

@Preview
@SuppressLint("UnrememberedMutableState")
@Composable
fun DatePickerDialogSample() {
}