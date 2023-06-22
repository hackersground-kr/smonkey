package com.project.smonkey.domain.feed.repository

import com.project.smonkey.domain.feed.entity.Feed
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedRepository : CrudRepository<Feed, Long> {
    override fun findAll(): List<Feed>
}
