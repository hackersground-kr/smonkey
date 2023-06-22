package com.project.smonkey.domain.smonkey.scheduler

import com.project.smonkey.domain.smonkey.repository.SMonkeyRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PointScheduler(
    private val smonkeyRepository: SMonkeyRepository
) {

    @Transactional
    @Scheduled(cron = "0 0 1 * * *")
    fun addPoint() {
        smonkeyRepository.findAll().forEach { smonkey ->
            smonkey.updatePoint(smonkey.point + 10)
        }
    }
}
