package com.saehyun.presentation.feature.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.component.BigTopAppBar
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.style.SmonkeyBody1
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun CommunityScreen(
    vm: CommunityViewModel,
) {
    val state = vm.container.stateFlow.collectAsState().value

    LaunchedEffect(key1 = vm) {
        fun handleSideEffect(sideEffect: CommunitySideEffect) {

        }

        vm.container.sideEffectFlow
            .onEach(::handleSideEffect)
            .launchIn(this)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        BigTopAppBar(
            leadingContent = { SmonkeyBody1(text = "커뮤니티") },
            trailingContent = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_search_green_24),
                        contentDescription = null,
                    )
                    Spacer(space = 24.dp)
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_pen_green_24),
                        contentDescription = null,
                    )
                }
            },
        )
        SMonkeyTabLayout(
            tabs = listOf("전체", "정보", "고민", "질문", "캠페인"),
            selectedTabIndex = 3,
            onTabSelected = { selectedIndex ->

            },
        )
        Column {

        }
    }
}