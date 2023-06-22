@file:OptIn(ExperimentalFoundationApi::class)

package com.saehyun.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.saehyun.presentation.component.SMonkeyHorizontalPagerIndicator
import com.saehyun.presentation.component.SMonkeyLargeButton
import com.saehyun.presentation.component.SMonkeyOutlineLargeButton
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.component.toSmonkeyCharacter
import com.saehyun.presentation.feature.login.SignInActivity
import com.saehyun.presentation.feature.signup.SignUpActivity
import com.saehyun.presentation.style.SMonkeyTheme
import com.saehyun.presentation.style.SmonkeyBody3
import com.saehyun.presentation.style.SmonkeyBody4
import com.saehyun.presentation.util.startActivityWithAnimation
import com.saehyun.presentation.util.systemBarPaddings
import okhttp3.internal.immutableListOf


class IntroActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCenter.start(
            application,
            BuildConfig.APP_SECRET,
            Analytics::class.java, Crashes::class.java
        )

        setContent {
            SMonkeyTheme {
                IntroScreen(
                    navigateToSignIn = {
                        navigateToSignIn()
                    },
                    navigateToSignUp = {
                        navigateToSignUp()
                    },
                )
            }
        }
    }

    private fun navigateToSignIn() {
        startActivityWithAnimation<SignInActivity>()
    }

    private fun navigateToSignUp() {
        startActivityWithAnimation<SignUpActivity>()
    }
}

@Composable
private fun IntroScreen(
    navigateToSignIn: () -> Unit,
    navigateToSignUp: () -> Unit,
) {
    val pagerState = rememberPagerState()
    val items = immutableListOf(
        Pair("담배, 끊기 너무나도 어렵죠!?", ""),
        Pair("스몽키를 통해 기존과는 다르게", "금연 실천해보세요!"),
        Pair("스몽키를 키우는 재미로", "동기부여를 할 수 있어요!"),
        Pair("다양한 기능을 통해", "금연을 도와드릴게요!"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(systemBarPaddings),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(space = 80.dp)
        SMonkeyHorizontalPagerIndicator(pagerState = pagerState, pageCount = items.size)
        Spacer(space = 40.dp)
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            pageCount = items.size,
            state = pagerState,
        ) { index ->
            val item = items.get(index)
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SmonkeyBody4(
                    text = item.first,
                    align = TextAlign.Center,
                )
                SmonkeyBody3(
                    text = item.second,
                    align = TextAlign.Center,
                )
                Spacer(space = 20.dp)
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    painter = painterResource(id = index.plus(1).toSmonkeyCharacter()),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                )
            }
        }
        Spacer(weight = 1f)
        SMonkeyLargeButton(
            text = "회원기입",
            enabled = true,
        ) {
            navigateToSignUp()
        }
        Spacer(space = 12.dp)
        SMonkeyOutlineLargeButton(
            text = "로그인",
            enabled = true,
        ) {
            navigateToSignIn()
        }
        Spacer(space = 32.dp)
    }
}
