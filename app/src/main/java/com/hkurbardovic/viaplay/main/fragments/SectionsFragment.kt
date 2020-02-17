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
import com.hkurbardovic.viaplay.main.viewmodels.SectionsViewModel
import com.hkurbardovic.viaplay.main.viewmodels.SectionsViewModelFactory
import javax.inject.Inject

class SectionsFragment : BaseFragment() {

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

        val adapter = SectionAdapter()
        binding.recyclerView.adapter = adapter

        sectionsViewModel.getSections()

        observeLiveData(adapter)

        return binding.root
    }

    private fun observeLiveData(adapter: SectionAdapter) {
        sectionsViewModel.sectionsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        sectionsViewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            println()
        }
    }

    companion object {
        fun newInstance() = SectionsFragment()
    }
}