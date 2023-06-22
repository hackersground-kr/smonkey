package com.saehyun.presentation.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.saehyun.presentation.component.SMonkeyBottomNavigation
import com.saehyun.presentation.feature.community.CommunityScreen
import com.saehyun.presentation.feature.community.CommunityViewModel
import com.saehyun.presentation.feature.journal.JournalScreen
import com.saehyun.presentation.feature.journal.JournalViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val homeVM: HomeViewModel by viewModels()
    private val journalVM: JournalViewModel by viewModels()
    private val communityVM: CommunityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = homeVM.container.stateFlow.collectAsState().value

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Crossfade(targetState = state.selectedIndex, label = "") { index ->
                    when (index) {
                        0 -> HomeScreen(vm = homeVM)
                        1 -> JournalScreen(vm = journalVM)
                        2 -> CommunityScreen(vm = communityVM)
                    }
                }
                SMonkeyBottomNavigation(
                    selectedIndex = state.selectedIndex,
                    onClick = { selectedIndex ->
                        homeVM.updateSelectedIndex(selectedIndex)
                    },
                )
            }
        }
        homeVM.observe(
            lifecycleOwner = this,
            sideEffect = ::handleSideEffect
        )
    }

    private fun handleSideEffect(sideEffect: HomeSideEffect) {

    }
}
