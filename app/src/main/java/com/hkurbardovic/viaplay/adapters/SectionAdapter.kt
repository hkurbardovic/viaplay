package com.hkurbardovic.viaplay.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hkurbardovic.viaplay.database.models.Section
import com.hkurbardovic.viaplay.databinding.ItemSectionBinding
import com.hkurbardovic.viaplay.handlers.click.ClickHandler
import com.hkurbardovic.viaplay.handlers.commands.AddFragmentCommand
import com.hkurbardovic.viaplay.main.fragments.SectionDetailsFragment

class SectionAdapter(val context: Context) :
    PagedListAdapter<Section, SectionAdapter.ViewHolder>(DeviceDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val section = getItem(position)
        holder.apply { bind(context, section) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSectionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    class ViewHolder(private val binding: ItemSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, section: Section?) {
            binding.apply {
                this.clickHandler =
                    ClickHandler()
                this.addFragmentCommand =
                    AddFragmentCommand(
                        context,
                        SectionDetailsFragment.newInstance(section?.id, section?.href)
                    )
                this.section = section
                executePendingBindings()
            }
        }
    }
}

private class DeviceDiffCallback : DiffUtil.ItemCallback<Section>() {

    override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
        return oldItem == newItem
    }
}