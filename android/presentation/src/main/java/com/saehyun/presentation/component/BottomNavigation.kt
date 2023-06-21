package com.saehyun.presentation.component

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody10
import com.saehyun.presentation.util.smonkeyClickable
import okhttp3.internal.immutableListOf


private object SMonkeyBottomNavigationDefaults {
    val Height = 52.dp
    val BackgroundColor = SMonkeyColor.White

    val IconSize = DpSize(width = 24.dp, height = 24.dp)
}

@Composable
internal fun SMonkeyBottomNavigation(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    onClick: (index: Int) -> Unit,
): Unit = with(SMonkeyBottomNavigationDefaults) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(
                height = Height,
            )
            .background(
                color = BackgroundColor,
            ),
    ) {
        rememberBottomNavigationIcons().forEachIndexed { index, icons ->
            Column(
                modifier = Modifier
                    .weight(
                        weight = 1f,
                    )
                    .fillMaxSize()
                    .smonkeyClickable(
                        rippleEnabled = false,
                    ) {
                        onClick(
                            index,
                        )
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    modifier = Modifier.size(IconSize),
                    painter = painterResource(
                        id = icons.pick(
                            isSelected = index == selectedIndex,
                        )
                    ),
                    contentDescription = null
                )
                if (index == selectedIndex) {
                    SmonkeyBody10(
                        text = stringResource(id = icons.title),
                        color = SMonkeyColor.Main1
                    )
                }
            }
        }
    }
}

@Composable
private fun rememberBottomNavigationIcons() = remember {
    immutableListOf(
        BottomNavigationIcon(
            defaultIcon = R.drawable.ic_home_gray_24,
            selectedIcon = R.drawable.ic_home_green_24,
            title = R.string.home,
        ),
        BottomNavigationIcon(
            defaultIcon = R.drawable.ic_journal_gray_24,
            selectedIcon = R.drawable.ic_journal_green_24,
            title = R.string.journal,
        ),
        BottomNavigationIcon(
            defaultIcon = R.drawable.ic_community_gray_24,
            selectedIcon = R.drawable.ic_community_green_24,
            title = R.string.community,
        ),
        BottomNavigationIcon(
            defaultIcon = R.drawable.ic_friend_gray_24,
            selectedIcon = R.drawable.ic_friend_green_24,
            title = R.string.friend,
        ),
        BottomNavigationIcon(
            defaultIcon = R.drawable.ic_setting_gray_24,
            selectedIcon = R.drawable.ic_setting_green_24,
            title = R.string.setting,
        ),
    )
}

private data class BottomNavigationIcon(
    @DrawableRes
    val defaultIcon: Int,
    @DrawableRes
    val selectedIcon: Int,
    @StringRes
    val title: Int,
) {
    @Stable
    fun pick(
        isSelected: Boolean,
    ) = when (isSelected) {
        true -> selectedIcon
        else -> defaultIcon
    }
}
