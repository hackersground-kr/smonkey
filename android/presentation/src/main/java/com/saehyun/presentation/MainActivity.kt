package com.saehyun.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saehyun.presentation.feature.home.HomeActivity
import com.saehyun.presentation.feature.login.SignInActivity
import com.saehyun.presentation.feature.signup.SignUpActivity
import com.saehyun.presentation.style.SMonkeyTheme
import com.saehyun.presentation.util.startActivityWithAnimation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateToLogin()
        setContent {
            SMonkeyTheme {

            }
        }
    }

    private fun navigateToLogin() {
        startActivityWithAnimation<SignInActivity>()
    }

    private fun navigateToSignUp() {
        startActivityWithAnimation<SignUpActivity>()
    }

    private fun navigateToHome() {
        startActivityWithAnimation<HomeActivity>()
    }
}
