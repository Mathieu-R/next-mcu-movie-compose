package com.mathieu.next_mcu.data

import java.lang.Exception

// Wrapper for our JSON response
sealed class CustomResponse<out T> {
  data class Success<out T>(val data: T): CustomResponse<T>()
  data class Failed(val message: String? = null): CustomResponse<Nothing>()
  data class Error(val exception: Exception): CustomResponse<Nothing>()
  data class Loading(val nothing: Nothing? = null): CustomResponse<Nothing>()
}