package com.hkurbardovic.viaplay.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.hkurbardovic.viaplay.adapters.SectionAdapter
import com.hkurbardovic.viaplay.base.BaseFragment
import com.hkurbardovic.viaplay.databinding.FragmentSectionsBinding
import com.hkurbardovic.viaplay.main.MainActivity
import com.hkurbardovic.viaplay.main.viewmodels.SectionsViewModel
import com.hkurbardovic.viaplay.main.viewmodels.SectionsViewModelFactory
import javax.inject.Inject

class SectionsFragment : BaseFragment(), MainActivity.NetworkListener {

    private lateinit var binding: FragmentSectionsBinding

    @Inject
    lateinit var sectionsViewModelFactory: SectionsViewModelFactory

    private val sectionsViewModel: SectionsViewModel by viewModels {
        sectionsViewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSectionsBinding.inflate(inflater, container, false)

        val context = context ?: return binding.root

        (context as MainActivity).setNetworkListener(this)

        val adapter = SectionAdapter(context)
        binding.recyclerView.adapter = adapter

        observeLiveData(adapter)

        getSections()

        return binding.root
    }

    override fun onAvailable() {
        getSections()
    }

    private fun observeLiveData(adapter: SectionAdapter) {
        sectionsViewModel.sectionsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        sectionsViewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            handleError(it)
        }

        sectionsViewModel.isLoadingLiveData.observe(viewLifecycleOwner) {
            binding.isLoading = it
        }
    }

    private fun getSections() {
        sectionsViewModel.getSections()
    }

    companion object {
        fun newInstance() = SectionsFragment()
    }
}