package com.digi.jetpacksample.data.repository

import com.digi.jetpacksample.data.remote.ItemRemoteDataSource
import javax.inject.Inject

class ItemRepository @Inject constructor(
	private val itemRemoteDataSource: ItemRemoteDataSource):Repository{
	
	fun getRemoteAndLocalFlow() = itemRemoteDataSource.getRemoteAndLocalFlow()
}
