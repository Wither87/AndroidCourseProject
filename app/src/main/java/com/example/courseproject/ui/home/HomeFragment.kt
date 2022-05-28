package com.example.courseproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.MainActivity
import com.example.courseproject.R
import com.example.courseproject.ViewModelFactory
import com.example.courseproject.appComponent
import com.example.courseproject.databinding.FragmentHomeBinding
import com.example.courseproject.ui.OnItemClickListener
import com.example.courseproject.ui.phone.PhoneFragment
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).appComponent.inject(this)
        homeViewModel = viewModelFactory.create(HomeViewModel::class.java)

        displayBrands()
    }

    private var brandsAdapter: BrandsAdapter = BrandsAdapter(listOf())
    private fun displayBrands(){
        homeViewModel.brandsLiveData.observe(this, Observer{
            val brands = it
            Log.i("brands", "brands list size: " + brands.size.toString())
            brandsAdapter = BrandsAdapter(brands)
            brandsAdapter.setOnItemClickListener(object : OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val brandSlug = brands[position].Brand_slug
                    val bundle = Bundle()
                    bundle.putString(PhoneFragment.ARG_BRAND_SLUG, brandSlug)
                    findNavController().navigate(R.id.navigation_phone, bundle)
                }
            })
            binding.brandsRecycler.adapter = brandsAdapter
        })
        homeViewModel.loadBrands()

        //binding.brandsRecycler.adapter = brandsAdapter
        val brandsDividerItemDecoration = DividerItemDecoration(this.activity, RecyclerView.VERTICAL)
        brandsDividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.brands_decoration))
        binding.brandsRecycler.addItemDecoration(brandsDividerItemDecoration)
    }
}