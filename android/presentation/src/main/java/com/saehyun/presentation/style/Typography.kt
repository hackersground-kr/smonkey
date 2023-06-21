package com.saehyun.presentation.style

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.saehyun.common_kotlin.runIf
import com.saehyun.presentation.R
import com.saehyun.presentation.util.smonkeyClickable

internal val pretendardFamily = FontFamily(
    Font(R.font.pretendard_black, FontWeight.Black),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_thin, FontWeight.Thin),
    Font(R.font.pretendrad_extra_bold, FontWeight.ExtraBold),
)

internal object SmonkeyTextStyle {
    val Body1 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body2 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body3 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body4 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body5 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body6 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body7 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body8 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body9 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 10.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body10 = TextStyle(
        color = SMonkeyColor.Black,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
}

@Composable
fun SmonkeyBody1(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body1.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody2(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body2.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody3(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body3.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody4(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body4.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody5(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body5.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody6(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body6.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody7(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body7.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody8(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body8.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody9(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body9.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun SmonkeyBody10(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = SMonkeyColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .smonkeyClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = SmonkeyTextStyle.Body10.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}