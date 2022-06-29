package com.hitrosttech.currency.data.remote.dto

import com.hitrosttech.currency.domain.model.Coin

//Data coming in from the Api
data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

// Data needed being routed to the Domain Data Class
fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}