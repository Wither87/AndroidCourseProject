package com.example.courseproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.courseproject.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayBrands()

        // TODO: Use the ViewModel
    }




    private fun displayBrands(){
        viewModel.brandsLiveData.observe(this, Observer{
            val brands = it
            // TODO отобразить список брендов
        })
        viewModel.loadBrands()
    }

    private fun displayPhones(brandSlug: String){
        viewModel.phonesLiveData.observe(this, Observer{
            val phones = it
            // TODO отобразить список телефонов
        })
        viewModel.loadPhones(brandSlug)
    }

    private fun displayPhoneDetails(phoneSlug: String){
        viewModel.phoneDetailsLiveData.observe(this, Observer{
            val phoneDetails = it
            // TODO отобразить информацию о телефоне
        })
        viewModel.loadPhoneDetails(phoneSlug)
    }

}