package com.hitrosttech.currency.domain.repository

import com.hitrosttech.currency.data.remote.dto.CoinDetailDto
import com.hitrosttech.currency.data.remote.dto.CoinDto

interface CoinRepository {
	
	suspend fun getCoins(): List<CoinDto>
	
	suspend fun getCoinById(coin_id : String) : CoinDetailDto
}