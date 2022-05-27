package com.example.courseproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.courseproject.MainActivity
import com.example.courseproject.appComponent
import com.example.courseproject.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
        //return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).appComponent.inject(this)
        viewModel = viewModelFactory.create(MainViewModel::class.java)// ViewModelProvider(this).get(MainViewModel::class.java)

        displayBrands()

        // TODO: Use the ViewModel
    }




    private fun displayBrands(){
        viewModel.brandsLiveData.observe(this, Observer{
            val brands = it
            // TODO отобразить список брендов
        })
        viewModel.loadBrands()
        binding.message.text = "Вью биндинг Работает"
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