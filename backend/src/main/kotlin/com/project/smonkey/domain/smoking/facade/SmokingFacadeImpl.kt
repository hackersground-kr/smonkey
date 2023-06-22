package com.project.smonkey.domain.smoking.facade

import com.project.smonkey.domain.smoking.entity.Smoking
import com.project.smonkey.domain.smoking.exception.SmokingAlreadyExistException
import com.project.smonkey.domain.smoking.exception.SmokingNotFoundException
import com.project.smonkey.domain.smoking.repository.SmokingRepository
import org.springframework.stereotype.Component

@Component
class SmokingFacadeImpl(
    private val smokingRepository: SmokingRepository
) : SmokingFacade {

    override fun getSmokingByUserId(
        userId: Long,
    ): Smoking {
        return smokingRepository.findByUserId(
            userId = userId,
        ) ?: throw SmokingNotFoundException
    }

    override fun saveSmoking(smoking: Smoking) {
        if (smokingRepository.existsById(smoking.userId))
            throw SmokingAlreadyExistException

        smokingRepository.save(smoking)
    }
}
