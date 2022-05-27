package com.example.courseproject.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.courseproject.R
import com.example.domain.models.Brand
import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BrandsAdapter : ListAdapter<Brand, BrandsAdapter.ViewHolder>(BrandItemDiffCallback())  {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val brandTitle = view.findViewById<TextView>(R.id.brandTitle)

        fun bind(brand: Brand) {
            brandTitle.text = brand.Brand_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.brand_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}