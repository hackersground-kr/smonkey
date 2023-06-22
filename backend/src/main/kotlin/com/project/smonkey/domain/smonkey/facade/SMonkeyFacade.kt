package com.project.smonkey.domain.smonkey.facade

import com.project.smonkey.domain.smonkey.entity.SMonkey

interface SMonkeyFacade {

    fun saveSMonkey(smonkey: SMonkey)

    fun getSMonkeyExist(userId: Long): Boolean

    fun getSMonkeyById(userId: Long): SMonkey

    fun getSMonkeyByIdWithDefault(
        userId: Long
    ): SMonkey
}
