package com.mathieu.next_mcu

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathieu.next_mcu.data.CustomResponse
import com.mathieu.next_mcu.model.NextMCUMovie
import com.mathieu.next_mcu.repository.MCURepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
  private val MCURepository: MCURepository
): ViewModel() {
  private val nextMCUMovie: MutableState<CustomResponse<NextMCUMovie>>? = null

  init {
    getNextMCUMovie()
  }

  private fun getNextMCUMovie() {
    viewModelScope.launch {
      nextMCUMovie?.value = MCURepository.getNextMCUMovie()
    }
  }
}