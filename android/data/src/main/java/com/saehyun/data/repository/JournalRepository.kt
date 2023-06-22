package com.saehyun.data.repository

import com.saehyun.data.network.journal.JournalRequest
import com.saehyun.data.network.journal.JournalResponse

interface JournalRepository {
    suspend fun getJournal(date: String): JournalResponse

    suspend fun writeJournal(request: JournalRequest)

    suspend fun deleteJournal(date: String)
}