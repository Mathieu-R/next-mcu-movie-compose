package com.mathieu.next_mcu.repository

import com.mathieu.next_mcu.data.CustomResponse
import com.mathieu.next_mcu.model.NextMCUMovie
import com.mathieu.next_mcu.network.MCUApi
import com.mathieu.next_mcu.network.handleApi
import javax.inject.Inject

class MCURepository @Inject constructor(
  private val MCUApi: MCUApi
) {

  suspend fun getNextMCUMovie(): CustomResponse<NextMCUMovie> {
    return handleApi({ MCUApi.getNextMCUMovie() })
  }
}