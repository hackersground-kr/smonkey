package com.saehyun.presentation.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(HomeState())

    fun updateSelectedIndex(index: Int) = intent {
        reduce {
            state.copy(
                selectedIndex = index,
            )
        }
    }
}