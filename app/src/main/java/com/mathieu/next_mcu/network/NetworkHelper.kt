package com.mathieu.next_mcu.network

import com.google.gson.JsonObject
import com.google.gson.JsonSyntaxException
import com.mathieu.next_mcu.data.CustomResponse
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

var isConnectedToNetwork = true

suspend fun <T: Any> handleApi(
  ApiCall: suspend () -> Response<T>,
  errorMessage: String = "Problem fetching the data."
): CustomResponse<T> {
  try {
    // fetching the data
    val response = ApiCall()

    // if successful fetching
    if (response.isSuccessful) {
      isConnectedToNetwork = true
      // let seems to be like ".then()" in JS
      response.body()?.let {
        return CustomResponse.Success(it)
      }
    }

    // otherwise
    // try to return the error message
    response.errorBody()?.let {
      return try {
        val errorAsString = it.string()
        val errorAsObject = JSONObject(errorAsString)

        CustomResponse.Failed(
          message = errorAsObject.getString("status_message") ?: errorMessage
        )
      } catch (e: JsonSyntaxException) {
        CustomResponse.Failed(
          message = e.message
        )
      }
    }

    // if we cannot return the error message, return a generic one
    return CustomResponse.Failed(message = errorMessage)
  } catch (e: Exception) {
    if (e is IOException) {
      isConnectedToNetwork = false
    }

    return CustomResponse.Failed(e.message ?: errorMessage)
  }

}