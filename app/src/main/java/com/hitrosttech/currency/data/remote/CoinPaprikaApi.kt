package com.hitrosttech.currency.data.remote

import com.hitrosttech.currency.data.remote.dto.CoinDetailDto
import com.hitrosttech.currency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
	
	@GET("/v1/coins")
	suspend fun getCoins() : List<CoinDto>
	
	@GET("/v1/coins/{coin_id}")
	suspend fun getCoinById(@Path("coin_id") coin_id: String) : CoinDetailDto
}