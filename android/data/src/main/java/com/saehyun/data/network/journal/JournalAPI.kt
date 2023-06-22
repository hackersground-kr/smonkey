package com.saehyun.data.network.journal

import com.saehyun.data.network.BaseResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface JournalAPI {

    @GET("/journal")
    suspend fun getJournal(
        @Query("date") date: String,
    ): BaseResponse<JournalResponse>

    @POST("/journal")
    suspend fun writeJournal(
        @Body request: JournalRequest,
    ): BaseResponse<Unit>

    @DELETE("/journal")
    suspend fun deleteJournal(
        @Query("date") date: String,
    ): BaseResponse<Unit>

}