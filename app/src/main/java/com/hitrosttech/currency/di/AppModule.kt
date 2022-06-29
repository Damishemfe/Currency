package com.hitrosttech.currency.di

import com.hitrosttech.currency.common.Constants
import com.hitrosttech.currency.data.remote.CoinPaprikaApi
import com.hitrosttech.currency.data.repository.CoinRepositoryImpl
import com.hitrosttech.currency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	
	
	@Provides
	@Singleton
	fun providePaprikaApi(): CoinPaprikaApi {
		return Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(CoinPaprikaApi::class.java)
	}
	
	@Provides
	@Singleton
	fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
		return CoinRepositoryImpl(api)
	}
}