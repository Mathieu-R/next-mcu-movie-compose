package com.mathieu.next_mcu.repository

import android.util.Log
import com.mathieu.next_mcu.data.Response
import com.mathieu.next_mcu.model.NextMCUMovie
import com.mathieu.next_mcu.network.MCUApi
import javax.inject.Inject

class MCURepository @Inject constructor(
  private val api: MCUApi
) {
  suspend fun getNextMCUMovie(): Response<NextMCUMovie> {
    val response = try {
      api.getNextMCUMovie()
    } catch (error: Exception) {
      return Response.Error(message = "An unknown error occured")
      Log.d("Exc", error.localizedMessage)
    }

    return Response.Success(data = response)
  }
}