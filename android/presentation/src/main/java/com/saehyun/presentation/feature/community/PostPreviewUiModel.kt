package com.saehyun.presentation.feature.community

import androidx.compose.runtime.Immutable
import com.saehyun.domain.Writer

@Immutable
data class PostPreviewUiModel(
    val writer: Writer,
    val title: String,
    val content: String,
    val heartNum: Int,
    val commentNum: Int,
    val createAt: String,
) {
    companion object {
        fun dummy() = PostPreviewUiModel(
            writer = Writer.dummy(),
            title = "안녕안녕테승ㅌ",
            content = "쿠쿠루삥뽕",
            heartNum = 4,
            commentNum = 5,
            createAt = "2010.03.10"
        )
    }
}