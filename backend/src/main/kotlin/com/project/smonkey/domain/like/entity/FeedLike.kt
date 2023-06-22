package com.project.smonkey.domain.like.entity

import com.project.smonkey.domain.user.entity.User
import javax.persistence.*

@Entity
@Table(name = "post_likes")
class FeedLike(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    var user: User,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feed_id")
    var feed: com.project.smonkey.domain.feed.entity.Feed,
)
