package com.example.courseproject.ui.phonedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.courseproject.MainActivity
import com.example.courseproject.R
import com.example.courseproject.ViewModelFactory
import com.example.courseproject.appComponent
import com.example.courseproject.databinding.FragmentPhoneDetailsBinding
import javax.inject.Inject

class PhoneDetailsFragment : Fragment() {
    private var phoneSlug: String? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var phoneDetailsViewModel: PhoneDetailsViewModel

    private var _binding: FragmentPhoneDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhoneDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phoneSlug = arguments?.getString(ARG_PHONE_SLUG)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).appComponent.inject(this)
        phoneDetailsViewModel = viewModelFactory.create(PhoneDetailsViewModel::class.java)

        displayPhoneDetails()
    }

    private fun displayPhoneDetails(){
        phoneDetailsViewModel.isLoadedLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.phoneDetailsProgressBar.visibility = if(isLoading) View.GONE else View.VISIBLE
        })

        phoneDetailsViewModel.phoneDetailsLiveData.observe(this, Observer{
            val details = it
            binding.phoneDetailsBrand.text = getString(R.string.brand_info, details.Brand)
            binding.phoneDetailsName.text = getString(R.string.phone_name_info, details.Phone_name)
            binding.phoneDetailsReleaseDate.text = getString(R.string.release_date_info, details.Release_date)
            binding.phoneDetailsDimension.text = getString(R.string.dimension_info, details.Dimension)
            binding.phoneDetailsOs.text = getString(R.string.os_info, details.Os)
            binding.phoneDetailsStorage.text = getString(R.string.storage_info, details.Storage)
            binding.phoneDetailsSpecificationsRecycler.adapter = SpecificationsAdapter(details.Specifications)
        })
        phoneDetailsViewModel.loadPhoneDetails(phoneSlug!!)
    }

    companion object {
        const val ARG_PHONE_SLUG = "DetailsPhoneSlug"
    }
}