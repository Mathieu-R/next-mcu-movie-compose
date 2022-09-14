package com.mathieu.next_mcu.di

import com.mathieu.next_mcu.di.network.IMCUApi
import com.mathieu.next_mcu.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Singleton
  @Provides
  fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(Constants.API_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Singleton
  @Provides
  fun providesMCUApi(retrofit: Retrofit): IMCUApi {
    return retrofit.create(IMCUApi::class.java)
  }
}