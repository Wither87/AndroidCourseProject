package com.example.courseproject.ui.phone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.MainActivity
import com.example.courseproject.R
import com.example.courseproject.ViewModelFactory
import com.example.courseproject.appComponent
import com.example.courseproject.databinding.FragmentPhoneBinding
import com.example.courseproject.ui.OnItemClickListener
import com.example.courseproject.ui.phonedetails.PhoneDetailsFragment
import javax.inject.Inject

class PhoneFragment : Fragment() {
    private var brandSlug: String? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var phoneViewModel: PhoneViewModel

    private var _binding: FragmentPhoneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        brandSlug = arguments?.getString(ARG_BRAND_SLUG)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).appComponent.inject(this)
        phoneViewModel = viewModelFactory.create(PhoneViewModel::class.java)

        displayPhones()
    }

    private var phoneAdapter: PhoneAdapter = PhoneAdapter(listOf())
    private fun displayPhones(){

        phoneViewModel.isLoadedLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.phonesProgressBar.visibility = if(isLoading) View.GONE else View.VISIBLE
        })
        phoneViewModel.phonesLiveData.observe(this, Observer{
            val phones = it
            Log.i("phones", "phones list size: " + phones.size.toString())
            phoneAdapter = PhoneAdapter(phones)
            phoneAdapter.setOnItemClickListener(object : OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val phoneSlug = phones[position].Slug
                    val bundle = Bundle()
                    bundle.putString(PhoneDetailsFragment.ARG_PHONE_SLUG, phoneSlug)
                    findNavController().navigate(R.id.navigation_phone_details, bundle)
                }
            })
            binding.phoneRecycler.adapter = phoneAdapter
        })
        phoneViewModel.loadPhones(brandSlug!!)

        val phoneDividerItemDecoration = DividerItemDecoration(this.activity, RecyclerView.VERTICAL)
        phoneDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.line_decoration))
        binding.phoneRecycler.addItemDecoration(phoneDividerItemDecoration)
    }

    companion object {
        const val ARG_BRAND_SLUG = "PhoneBrandSlug"
    }
}