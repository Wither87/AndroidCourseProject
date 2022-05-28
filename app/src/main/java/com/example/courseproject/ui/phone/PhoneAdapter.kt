package com.example.courseproject.ui.phone

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.R
import com.example.courseproject.ui.OnItemClickListener
import com.example.domain.models.Phone

class PhoneAdapter(private val phoneList: List<Phone>) : RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    class PhoneViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {

        private val phoneTitle = view.findViewById<TextView>(R.id.phoneItemTitle)
        init {
            view.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
        fun bind(phone: Phone) {
            phoneTitle.text = phone.Phone_name
        }
    }

    private lateinit var mListener: OnItemClickListener
    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_item, parent, false)

        return PhoneViewHolder(view, mListener)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.bind(phoneList[position])
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
}