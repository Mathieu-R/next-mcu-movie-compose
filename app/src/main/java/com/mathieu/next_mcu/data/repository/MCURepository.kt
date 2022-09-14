package com.mathieu.next_mcu.data.repository

import com.mathieu.next_mcu.data.CustomResponse
import com.mathieu.next_mcu.data.model.NextMCUMovie
import com.mathieu.next_mcu.di.network.IMCUApi
import com.mathieu.next_mcu.di.network.handleApi
import javax.inject.Inject

class MCURepository @Inject constructor(
  private val MCUApi: IMCUApi
) {

  suspend fun getNextMCUMovie(): CustomResponse<NextMCUMovie> {
    return handleApi({ MCUApi.getNextMCUMovie() })
  }
}