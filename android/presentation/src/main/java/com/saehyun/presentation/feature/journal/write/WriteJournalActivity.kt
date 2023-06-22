package com.saehyun.presentation.feature.journal.write

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.saehyun.presentation.util.finishWithAnimation
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class WriteJournalActivity : ComponentActivity() {

    private val vm: WriteJournalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.observe(
            lifecycleOwner = this,
            sideEffect = ::handleSideEffect,
        )
        setContent {
            val state = vm.container.stateFlow.collectAsState().value

            WriteJournalScreen(
                title = state.title,
                content = state.content,
                selectedButton = state.selectedButton,
                onTitleChanged = vm::updateTitle,
                onContentChanged = vm::updateContent,
                onSelectedButtonChanged = vm::updateSelectedButton,
                onWrite = vm::writeJournal,
            )
        }
    }

    private fun handleSideEffect(sideEffect: WriteJournalSideEffect) {
        when (sideEffect) {
            is WriteJournalSideEffect.SendMessage -> {
                Toast.makeText(this, sideEffect.message, Toast.LENGTH_SHORT).show()
            }

            is WriteJournalSideEffect.Success -> {
                Toast.makeText(this, "일지를 성공적으로 등록하였습니다.", Toast.LENGTH_SHORT).show()
                finishWithAnimation()
            }
        }
    }
}