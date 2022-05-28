package com.example.courseproject.ui.phone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.courseproject.R

class PhoneFragment : Fragment() {
    private var brandSlug: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        brandSlug = arguments?.getString(ARG_BRAND_SLUG)
        val text = view.findViewById<TextView>(R.id.testText)
        text.text = brandSlug
    }

    companion object {
        const val ARG_BRAND_SLUG = "PhoneBrandSlug"
    }
}