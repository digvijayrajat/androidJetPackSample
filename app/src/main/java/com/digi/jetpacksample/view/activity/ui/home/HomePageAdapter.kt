package com.digi.jetpacksample.view.activity.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.digi.jetpacksample.data.model.Item
import com.digi.jetpacksample.databinding.ItemBinding
import kotlinx.coroutines.Dispatchers

class HomePageAdapter(diffCallback: DiffUtil.ItemCallback<Item>):
	PagingDataAdapter<Item, HomeItemViewHolder>(
		diffCallback = diffCallback,
		workerDispatcher = Dispatchers.IO) {
	
	override fun onBindViewHolder(holderHome: HomeItemViewHolder, position: Int) {
		getItem(position)?.let { holderHome.bind(it) }
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
		val itemView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return HomeItemViewHolder(itemView)
	}
}

object ItemComparator: DiffUtil.ItemCallback<Item>() {
	override fun areItemsTheSame(oldItem: Item, newItem: Item)
			= oldItem.id == newItem.id
	
	override fun areContentsTheSame(oldItem: Item, newItem: Item)
			= oldItem == newItem
}