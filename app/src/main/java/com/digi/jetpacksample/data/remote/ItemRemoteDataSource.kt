package com.digi.jetpacksample.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.digi.jetpacksample.data.db.AppDatabase
import com.digi.jetpacksample.paging.ItemRemoteMediator
import javax.inject.Inject

class ItemRemoteDataSource @Inject constructor(
	private val appDatabase: AppDatabase,
	private val itemRemoteMediator: ItemRemoteMediator) : BaseDataSource {
	
	fun getRemoteAndLocalFlow() = Pager(
		config =  PagingConfig(5),
		remoteMediator = itemRemoteMediator
	){
		appDatabase.itemDao().getAllItems()
	}.flow
	
}