package com.saehyun.data.network.journal

import com.saehyun.data.network.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface JournalAPI {

    @GET("/journal")
    suspend fun getJournal(
        date: String,
    ): BaseResponse<JournalResponse>

    @POST("/journal")
    suspend fun writeJournal(
        request: JournalRequest,
    ): BaseResponse<Unit>

    @DELETE("/journal")
    suspend fun deleteJournal(
        date: String,
    ): BaseResponse<Unit>

}