package com.saehyun.presentation.feature.community

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(

): ContainerHost<CommunityState, CommunitySideEffect>, ViewModel(){

    override val container = container<CommunityState, CommunitySideEffect>(CommunityState())
}