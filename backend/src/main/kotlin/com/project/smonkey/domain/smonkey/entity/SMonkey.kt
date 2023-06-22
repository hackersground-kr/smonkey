package com.project.smonkey.domain.smonkey.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class SMonkey(
    userId: Long,
    name: String,
    backgroundColor: String,
    point: Int,
    savePrice: Int,
    spendPrice: Int,
    noSmokingDate: Int,
    smokingDate: Int,
) {
    @Id
    var userId = userId
        protected set

    var name = name
        protected set

    var backgroundColor = backgroundColor
        protected set

    var point = point
        protected set

    var savePrice = savePrice
        protected set

    var spendPrice = spendPrice
        protected set

    var noSmokingDate = noSmokingDate
        protected set

    var smokingDate = smokingDate
        protected set

    fun updateColor(
        backgroundColor: String,
    ): SMonkey {
        this.backgroundColor = backgroundColor
        return this
    }

    fun updatePoint(
        point: Int,
    ): SMonkey {
        this.point = point
        return this
    }

    fun addSavePrice(
        price: Int,
    ): SMonkey {
        this.savePrice += price
        return this
    }

    fun addSpendPrice(
        price: Int,
    ): SMonkey {
        this.spendPrice += price
        return this
    }

    fun updateNoSmokingDate(
        date: Int,
    ): SMonkey {
        this.noSmokingDate += date
        return this
    }

    fun updateSmokingDate(
        date: Int,
    ): SMonkey {
        this.smokingDate += date
        return this
    }
}
