package com.hitrosttech.currency.data.repository

import com.hitrosttech.currency.data.remote.CoinPaprikaApi
import com.hitrosttech.currency.data.remote.dto.CoinDetailDto
import com.hitrosttech.currency.data.remote.dto.CoinDto
import com.hitrosttech.currency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
	private val api: CoinPaprikaApi
) : CoinRepository {
	override suspend fun getCoins(): List<CoinDto> {
		return api.getCoins()
	}
	
	override suspend fun getCoinById(coin_id: String): CoinDetailDto {
		return api.getCoinById(coin_id)
	}
}