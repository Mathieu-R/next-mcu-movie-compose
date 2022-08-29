package com.mathieu.next_mcu.network

import com.mathieu.next_mcu.model.NextMCUMovie
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface MCUApi {
  @GET("/api")
  suspend fun getNextMCUMovie(): NextMCUMovie
}