package com.digi.jetpacksample.di

import com.digi.jetpacksample.data.db.AppDatabase
import com.digi.jetpacksample.data.remote.HomeItemService
import com.digi.jetpacksample.data.remote.ItemRemoteDataSource
import com.digi.jetpacksample.data.repository.ItemRepository
import com.digi.jetpacksample.paging.ItemPageSource
import com.digi.jetpacksample.paging.ItemRemoteMediator
import com.digi.jetpacksample.view.activity.ui.home.HomePageAdapter
import com.digi.jetpacksample.view.activity.ui.home.ItemComparator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object HomeModule {

	@Provides
	fun provideHomeItemService(retrofit: Retrofit): HomeItemService =
		retrofit.create(HomeItemService::class.java)
	
	@Provides
	fun provideItemRemoteMediator(appDatabase: AppDatabase,homeItemService:HomeItemService) =
		ItemRemoteMediator(appDatabase,homeItemService)
	
	@Provides
	fun provideRemoteItemDataSource(appDatabase: AppDatabase,itemRemoteMediator: ItemRemoteMediator) =
		ItemRemoteDataSource(appDatabase,itemRemoteMediator)
	
	@Provides
	fun provideItemRepository(itemRemoteDataSource: ItemRemoteDataSource) =
		ItemRepository(itemRemoteDataSource)
	
	@Provides
	fun provideItemPageSource(homeItemService: HomeItemService) =
		ItemPageSource(homeItemService)
	
	@Provides
	fun provideHomePageAdapter() =
		HomePageAdapter(ItemComparator)
}