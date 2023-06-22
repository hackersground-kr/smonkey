package com.project.smonkey.domain.feed.entity

import com.project.smonkey.domain.feed.enum.FeedType
import com.project.smonkey.domain.user.entity.User
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
class Feed(
    title: String,
    content: String,
    category: FeedType,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @NotNull
    var title = title
        protected set

    @NotNull
    var content = content
        protected set

    @NotNull
    var category = category
        protected set

    @CreatedDate
    @NotNull
    var createdAt: LocalDateTime? = null
        protected set

    fun update(
        title: String,
        content: String,
        category: FeedType,
    ) {
        this.title = title
        this.content = content
        this.category = category
    }
}
