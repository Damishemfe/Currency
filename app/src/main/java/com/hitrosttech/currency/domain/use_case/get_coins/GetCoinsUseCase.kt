package com.hitrosttech.currency.domain.use_case.get_coins

import com.hitrosttech.currency.common.Resource
import com.hitrosttech.currency.data.remote.dto.toCoin
import com.hitrosttech.currency.domain.model.Coin
import com.hitrosttech.currency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
	private val repository: CoinRepository
) {
	operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
		try {
			emit(Resource.Loading())
			val coins = repository.getCoins().map { it.toCoin() }
			emit(Resource.Success(coins))
		} catch (e: HttpException) {
			emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
		} catch (e: IOException) {
			emit(Resource.Error("404 couldn't reach server. Please check your internet connection"))
		}
	}
}