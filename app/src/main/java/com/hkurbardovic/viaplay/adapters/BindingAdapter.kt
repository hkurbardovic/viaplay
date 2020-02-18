package com.hkurbardovic.viaplay.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.hkurbardovic.viaplay.database.models.Section
import com.hkurbardovic.viaplay.database.models.SectionDetails
import java.util.*

@BindingAdapter("sectionData")
fun bindSectionData(view: TextView, section: Section?) {
    section?.let {
        view.text = String.format(
            Locale.getDefault(),
            "id: %s\ntitle: %s\nhref: %s\ntype: %s\nname: %s\ntemplated: %s",
            it.id, it.title, it.href, it.type, it.name, it.templated
        )
    }
}

@BindingAdapter("sectionDetailsData")
fun bindSectionData(view: TextView, sectionDetails: SectionDetails?) {
    sectionDetails?.let {
        view.text = String.format(
            Locale.getDefault(),
            "sectionId: %s\ntype: %s\npageType: %s\ntitle: %s\ndescription: %s",
            it.sectionId, it.type, it.pageType, it.title, it.description
        )
    }
}