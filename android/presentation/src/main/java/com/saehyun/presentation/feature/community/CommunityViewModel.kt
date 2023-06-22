package com.saehyun.presentation.feature.community

import androidx.lifecycle.ViewModel
import com.saehyun.data.repository.FeedRepositoryImpl
import com.saehyun.data.util.FeedType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import okhttp3.internal.toImmutableList
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val feedRepositoryImpl: FeedRepositoryImpl,
) : ContainerHost<CommunityState, CommunitySideEffect>, ViewModel() {

    override val container = container<CommunityState, CommunitySideEffect>(CommunityState())

    init {
        getFeeds()
    }

    fun getFeeds(category: FeedType = FeedType.ALL) = intent {
        kotlin.runCatching {
            feedRepositoryImpl.getFeedList(category)
        }.onSuccess { response ->
            val feeds = response.feedList.map { item ->
                PostPreviewUiModel(
                    writer = item.writer,
                    title = item.title,
                    content = item.content,
                    heartNum = item.likeCount,
                    commentNum = 0,
                    createAt = item.createdAt
                )
            }
            reduce { state.copy(feeds = feeds.toPersistentList()) }
        }.onFailure { exception ->

        }
    }
}