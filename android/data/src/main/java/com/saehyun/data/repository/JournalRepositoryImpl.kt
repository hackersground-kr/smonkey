package com.saehyun.data.repository

import com.saehyun.data.network.journal.JournalAPI
import com.saehyun.data.network.journal.JournalRequest
import com.saehyun.data.network.journal.JournalResponse
import javax.inject.Inject

class JournalRepositoryImpl @Inject constructor(
    private val journalAPI: JournalAPI
) : JournalRepository {
    override suspend fun getJournal(date: String): JournalResponse {
        return journalAPI.getJournal(date).content
    }

    override suspend fun writeJournal(request: JournalRequest) {
        return journalAPI.writeJournal(request).content
    }

    override suspend fun deleteJournal(date: String) {
        return journalAPI.deleteJournal(date).content
    }
}