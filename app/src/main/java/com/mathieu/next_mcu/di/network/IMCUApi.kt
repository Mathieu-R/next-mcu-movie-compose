package com.mathieu.next_mcu.di.network

import com.mathieu.next_mcu.data.model.NextMCUMovie
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface IMCUApi {

  @GET("/api")
  suspend fun getNextMCUMovie(): Response<NextMCUMovie>
}