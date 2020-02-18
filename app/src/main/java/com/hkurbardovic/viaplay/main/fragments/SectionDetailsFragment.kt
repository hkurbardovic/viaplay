package com.hkurbardovic.viaplay.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.hkurbardovic.viaplay.base.BaseFragment
import com.hkurbardovic.viaplay.databinding.FragmentSectionDetailsBinding
import com.hkurbardovic.viaplay.main.MainActivity
import com.hkurbardovic.viaplay.main.viewmodels.SectionDetailsViewModel
import com.hkurbardovic.viaplay.main.viewmodels.SectionDetailsViewModelFactory
import com.hkurbardovic.viaplay.utilities.StringUtils
import javax.inject.Inject

class SectionDetailsFragment : BaseFragment(), MainActivity.NetworkListener {

    private lateinit var binding: FragmentSectionDetailsBinding

    @Inject
    lateinit var sectionDetailsViewModelFactory: SectionDetailsViewModelFactory

    private val sectionDetailsViewModel: SectionDetailsViewModel by viewModels {
        sectionDetailsViewModelFactory
    }

    private var id: String? = null
    private var href: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSectionDetailsBinding.inflate(inflater, container, false)

        (context as MainActivity).setNetworkListener(this)

        observeLiveData()

        id = arguments?.getString(SECTION_DETAILS_FRAGMENT_ID) ?: ""
        href = arguments?.getString(SECTION_DETAILS_FRAGMENT_HREF) ?: ""

        getSectionDetails()

        return binding.root
    }

    override fun onAvailable() {
        getSectionDetails()
    }

    private fun observeLiveData() {
        sectionDetailsViewModel.sectionDetailsLiveData.observe(viewLifecycleOwner) {
            binding.sectionDetails = it
        }

        sectionDetailsViewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            handleError(it)
        }

        sectionDetailsViewModel.isLoadingLiveData.observe(viewLifecycleOwner) {
            binding.isLoading = it
        }
    }

    private fun getSectionDetails() {
        id?.let {
            sectionDetailsViewModel.postSectionIdValue(it)
        }
        href?.let {
            sectionDetailsViewModel.getSectionDetails(StringUtils.splitHref(it))
        }
    }

    companion object {
        private const val SECTION_DETAILS_FRAGMENT_ID =
            "SECTION_DETAILS_FRAGMENT_ID"
        private const val SECTION_DETAILS_FRAGMENT_HREF =
            "SECTION_DETAILS_FRAGMENT_HREF"

        fun newInstance(title: String?, href: String?) = SectionDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(SECTION_DETAILS_FRAGMENT_ID, title)
                putString(SECTION_DETAILS_FRAGMENT_HREF, href)
            }
        }
    }
}