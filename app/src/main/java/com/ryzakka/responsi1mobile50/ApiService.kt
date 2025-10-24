package com.ryzakka.responsi1mobile50

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("v4/teams/77")
    suspend fun getTeamDetails(
        @Header("X-Auth-Token") authToken: String
    ): Response<TeamResponse>
}
