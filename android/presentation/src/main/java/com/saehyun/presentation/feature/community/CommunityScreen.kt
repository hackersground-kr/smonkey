package com.saehyun.presentation.feature.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.component.BigTopAppBar
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.component.toSmonkeyCharacter
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody1
import com.saehyun.presentation.style.SmonkeyBody10
import com.saehyun.presentation.style.SmonkeyBody7
import com.saehyun.presentation.style.SmonkeyBody9
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun CommunityScreen(
    vm: CommunityViewModel,
) {
    val state = vm.container.stateFlow.collectAsState().value

    LaunchedEffect(Unit) {
        vm.getFeeds()
    }

    LaunchedEffect(key1 = vm) {
        fun handleSideEffect(sideEffect: CommunitySideEffect) {

        }

        vm.container.sideEffectFlow
            .onEach(::handleSideEffect)
            .launchIn(this)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        if(state.isLoading) {
            CircularProgressIndicator()
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
                selectedTabIndex = 0,
                onTabSelected = { selectedIndex ->

                },
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 56.dp,
                ),
            ) {
                items(state.feeds) { item ->
                    PostPreviewLayout(item = item)
                }
            }
        }
    }
}


@Composable
private fun PostPreviewLayout(
    modifier: Modifier = Modifier,
    item: PostPreviewUiModel,
) = with(item) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SMonkeyColor.White,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(all = 16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(36.dp),
                painter = painterResource(id = writer.step.toSmonkeyCharacter()),
                contentDescription = null,
            )
            Column {
                SmonkeyBody9(text = writer.smonkeyName)
                SmonkeyBody10(
                    text = writer.userName + "님",
                    color = SMonkeyColor.Gray800,
                )
            }
        }
        Spacer(space = 22.dp)
        SmonkeyBody7(text = title)
        Spacer(space = 8.dp)
        SmonkeyBody10(text = content)
        Spacer(space = 20.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_like_16),
                contentDescription = null,
            )
            Spacer(space = 8.dp)
            SmonkeyBody10(text = heartNum.toString())
            Spacer(space = 16.dp)
            Image(
                painter = painterResource(id = R.drawable.ic_like_16),
                contentDescription = null,
            )
            Spacer(space = 8.dp)
            SmonkeyBody10(text = commentNum.toString())
            Spacer(weight = 1f)
            SmonkeyBody10(text = createAt)
        }
    }
}