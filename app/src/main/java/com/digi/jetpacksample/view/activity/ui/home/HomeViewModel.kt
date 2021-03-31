package com.digi.jetpacksample.view.activity.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.digi.jetpacksample.data.repository.ItemRepository

class HomeViewModel @ViewModelInject constructor(
	repository: ItemRepository
	) : ViewModel() {
	val flowRemoteAndDb = repository.getRemoteAndLocalFlow()
}