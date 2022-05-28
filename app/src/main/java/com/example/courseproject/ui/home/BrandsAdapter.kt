package com.example.courseproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.courseproject.R
import com.example.domain.models.Brand
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.ui.OnItemClickListener

class BrandsAdapter(private val brandsList: List<Brand>) : RecyclerView.Adapter<BrandsAdapter.ViewHolder>() { // ListAdapter<Brand, BrandsAdapter.ViewHolder>(BrandItemDiffCallback())  {

    class ViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {

        private val brandTitle = view.findViewById<TextView>(R.id.brandTitle)
        init {
            view.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
        fun bind(brand: Brand) {
            brandTitle.text = brand.Brand_name
        }
    }

    private lateinit var mListener: OnItemClickListener
    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.brand_item, parent, false)

        return ViewHolder(view, mListener)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(currentList[position])
//    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(brandsList[position])
    }

    override fun getItemCount(): Int {
        return brandsList.size
    }
}