package com.example.courseproject.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.Brand

class BrandItemDiffCallback : DiffUtil.ItemCallback<Brand>() {
    override fun areItemsTheSame(oldItem: Brand, newItem: Brand): Boolean = oldItem.Brand_id == newItem.Brand_id

    override fun areContentsTheSame(oldItem: Brand, newItem: Brand): Boolean = oldItem == newItem
}