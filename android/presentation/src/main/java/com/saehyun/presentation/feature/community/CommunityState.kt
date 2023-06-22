package com.saehyun.presentation.feature.community

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import javax.annotation.concurrent.Immutable

@Immutable
data class CommunityState(
    val isLoading: Boolean = false,
    val feeds: ImmutableList<PostPreviewUiModel> = persistentListOf()
)
