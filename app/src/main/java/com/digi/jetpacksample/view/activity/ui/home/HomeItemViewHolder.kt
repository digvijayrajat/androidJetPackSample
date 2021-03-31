package com.digi.jetpacksample.view.activity.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digi.jetpacksample.data.model.Item
import com.digi.jetpacksample.databinding.ItemBinding

class HomeItemViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
	fun bind(item: Item){
		binding.item = item
		//view.imv_item_status.setImageDrawable(view.context .getDrawable(getItemStatusDrawable( item.status)))
		Glide.with(binding.imvItem)
			.load(item.image)
				.centerCrop()
			.into(binding.imvItem)
		binding.executePendingBindings()
	}
}