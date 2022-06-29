package com.hitrosttech.currency.presentation.coin_detail

import com.hitrosttech.currency.domain.model.Coin
import com.hitrosttech.currency.domain.model.CoinDetail

data class CoinDetailState (
	val isLoading: Boolean = false,
	val coin: CoinDetail? = null,
	val error: String = ""
)