package com.saehyun.presentation.feature.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.saehyun.presentation.component.SMonkeyBottomNavigation
import com.saehyun.presentation.feature.community.CommunityScreen
import com.saehyun.presentation.feature.community.CommunityViewModel
import com.saehyun.presentation.feature.journal.JournalScreen
import com.saehyun.presentation.feature.journal.JournalViewModel
import com.saehyun.presentation.feature.journal.write.WriteJournalActivity
import com.saehyun.presentation.util.startActivityWithAnimation
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

            LaunchedEffect(key1 = homeVM) {
                homeVM.getSmonkey()
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Crossfade(targetState = state.selectedIndex, label = "") { index ->
                    when (index) {
                        0 -> HomeScreen(
                            state = state,
                            navigateToWriteJournal = {
                                homeVM.navigateToWriteJournal()
                            },
                        )

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
        when (sideEffect) {
            is HomeSideEffect.SendMessage -> {
                Toast.makeText(this, sideEffect.message, Toast.LENGTH_SHORT).show()
            }

            is HomeSideEffect.NavigateToWriteJournal -> {
                startActivityWithAnimation<WriteJournalActivity>()
            }
        }
    }
}
