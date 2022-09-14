package com.mathieu.next_mcu.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathieu.next_mcu.data.CustomResponse
import com.mathieu.next_mcu.data.model.NextMCUMovie
import com.mathieu.next_mcu.data.repository.MCURepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
  private val MCURepository: MCURepository
): ViewModel() {
  private val nextMCUMovie: MutableLiveData<CustomResponse<NextMCUMovie>> = MutableLiveData()

  init {
    getNextMCUMovie()
  }

  private fun getNextMCUMovie() {
    viewModelScope.launch {
      nextMCUMovie.value = MCURepository.getNextMCUMovie()
    }
  }
}