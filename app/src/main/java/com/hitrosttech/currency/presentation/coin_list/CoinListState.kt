package com.hitrosttech.currency.presentation.coin_list

import com.hitrosttech.currency.domain.model.Coin

data class CoinListState (
	val isLoading: Boolean = false,
	val coins: List<Coin> = emptyList(),
	val error: String = ""
)