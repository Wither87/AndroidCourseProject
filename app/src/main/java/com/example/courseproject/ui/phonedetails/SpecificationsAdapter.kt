package com.example.courseproject.ui.phonedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.R
import com.example.domain.models.Specifications

class SpecificationsAdapter(private val specificationsList: List<Specifications>) : RecyclerView.Adapter<SpecificationsAdapter.SpecificationsViewHolder>() {

    class SpecificationsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val specificationTitle = view.findViewById<TextView>(R.id.specificationTitle)
        private val specsRecycler = view.findViewById<RecyclerView>(R.id.specificationSpecsRecycler)

        fun bind(specification: Specifications) {
            specificationTitle.text = "${specification.Title}: "
            specsRecycler.adapter = SpecsAdapter(specification.Specs)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecificationsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_specifications_item, parent, false)

        return SpecificationsViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: SpecificationsViewHolder, position: Int) {
        holder.bind(specificationsList[position])
    }

    override fun getItemCount(): Int {
        return specificationsList.size
    }
}