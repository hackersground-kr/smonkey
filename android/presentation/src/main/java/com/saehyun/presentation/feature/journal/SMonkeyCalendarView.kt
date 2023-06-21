package com.saehyun.presentation.feature.journal

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
