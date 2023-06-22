package com.saehyun.presentation.feature.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.SMonkeyCheckBox
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody6
import com.saehyun.presentation.util.smonkeyClickable

@Composable
internal fun SignUpCheckBox(
    modifier: Modifier = Modifier,
    visible: Boolean,
    reason: SmokingCessationReason,
    onClick: (SmokingCessationReason) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .smonkeyClickable {
                onClick(reason)
            }
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = SMonkeyColor.Gray200,
            )
            .border(
                width = 1.dp,
                color = SMonkeyColor.Gray300,
            )
            .padding(
                horizontal = 12.dp,
                vertical = 14.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SMonkeyCheckBox(isChecked = visible, onCheckedChange = { onClick(reason) })
        Spacer(space = 10.dp)
        SmonkeyBody6(text = reason.title)
    }
}
