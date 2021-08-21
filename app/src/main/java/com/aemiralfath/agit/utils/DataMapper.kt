package com.aemiralfath.agit.utils

import com.aemiralfath.agit.data.source.local.entity.CoinEntity
import com.aemiralfath.agit.data.source.remote.response.CoinResponse
import com.aemiralfath.agit.domain.model.Coin

object DataMapper {

    fun mapResponsesToEntities(input: List<CoinResponse>): List<CoinEntity> {
        val list = arrayListOf<CoinEntity>()
        input.map {
            val data = it.coinInfo
            val coin = CoinEntity(
                data?.id.toString(),
                data?.name.toString(),
                data?.fullName.toString(),
                data?.assetLaunchDate.toString(),
                data?.imageUrl.toString(),
                data?.algorithm.toString(),
                data?.url.toString(),
                data?.blockTime ?: 0,
                data?.maxSupply ?: 0,
                data?.netHashesPerSecond ?: 0,
                data?.blockNumber ?: 0,
                data?.blockReward ?: 0
            )
            list.add(coin)
        }
        return list
    }

    fun mapEntitiesToDomain(input: List<CoinEntity>): List<Coin> =
        input.map {
            Coin(
                it.id,
                it.name,
                it.fullName,
                it.date,
                it.imageUrl,
                it.algorithm,
                it.url,
                it.blockTime,
                it.maxSupply,
                it.netHashesPerSecond,
                it.blockNumber,
                it.blockReward,
                it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Coin) = CoinEntity(
        input.id,
        input.name,
        input.fullName,
        input.date,
        input.imageUrl,
        input.algorithm,
        input.url,
        input.blockTime,
        input.maxSupply,
        input.netHashesPerSecond,
        input.blockNumber,
        input.blockReward,
        input.isFavorite
    )

}