package com.example.courseproject.ui.phonedetails

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.R
import com.example.domain.models.Specs

class SpecsAdapter(private val specsList: List<Specs>) : RecyclerView.Adapter<SpecsAdapter.SpecsViewHolder>() {

    class SpecsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val keyTextView = view.findViewById<TextView>(R.id.specsKeyValue)
        fun bind(specs: Specs) {
            keyTextView.text = "${specs.Key}: ${specs.Val[0]}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_specifications_specs_item, parent, false)

        return SpecsViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: SpecsViewHolder, position: Int) {
        holder.bind(specsList[position])
    }

    override fun getItemCount(): Int {
        return specsList.size
    }
}