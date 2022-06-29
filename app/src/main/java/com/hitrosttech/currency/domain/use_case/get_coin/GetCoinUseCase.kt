package com.hitrosttech.currency.domain.use_case.get_coin

import com.hitrosttech.currency.common.Resource
import com.hitrosttech.currency.data.remote.dto.toCoin
import com.hitrosttech.currency.data.remote.dto.toCoinDetail
import com.hitrosttech.currency.domain.model.Coin
import com.hitrosttech.currency.domain.model.CoinDetail
import com.hitrosttech.currency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
	private val repository: CoinRepository
) {
	operator fun invoke(coin_id: String): Flow<Resource<CoinDetail>> = flow {
		try {
			emit(Resource.Loading())
			val coin = repository.getCoinById(coin_id).toCoinDetail()
			emit(Resource.Success(coin))
		} catch (e: HttpException) {
			emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
		} catch (e: IOException) {
			emit(Resource.Error("404 couldn't reach server. Please check your internet connection"))
		}
	}
}