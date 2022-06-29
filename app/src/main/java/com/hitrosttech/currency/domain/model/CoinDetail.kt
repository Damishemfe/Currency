package com.hitrosttech.currency.domain.model

import com.hitrosttech.currency.data.remote.dto.*

data class CoinDetail(
	val description: String,
	val coin_id: String,
	val is_active: Boolean,
	val name: String,
	val rank: Int,
	val symbol: String,
	val tags: List<String>,
	val team: List<TeamMember>,
)
