package com.saehyun.presentation.feature.community

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.saehyun.presentation.style.SMonkeyColor

@Composable
fun SMonkeyTabLayout(tabs: List<String>, selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    val selectedIndex = remember { mutableStateOf(selectedTabIndex) }

    TabRow(
        selectedTabIndex = selectedIndex.value,
        containerColor = SMonkeyColor.White,
        contentColor = SMonkeyColor.Black,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[selectedIndex.value]),
                color = SMonkeyColor.Main1
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(tab) },
                selected = selectedIndex.value == index,
                onClick = {
                    selectedIndex.value = index
                    onTabSelected(index)
                }
            )
        }
    }
}