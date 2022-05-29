package com.example.onboardtask.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboardtask.databinding.ItemBoardBinding
import com.example.onboardtask.extensions.gone
import com.example.onboardtask.extensions.loadImageWithGlide
import com.example.onboardtask.extensions.visible
import com.example.onboardtask.onboard.model.BoardModel

class ViewPagerAdapter(val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    var list: ArrayList<BoardModel> = arrayListOf()

    inner class ViewPagerViewHolder(val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: BoardModel) {
            binding.title.text = model.title
            binding.description.text = model.description
            binding.startBtn.text = model.bottomName
            binding.imImage.loadImageWithGlide(model.image)
            binding.startBtn.setOnClickListener {
                onItemClick(absoluteAdapterPosition)
            }
            if (model.description.isNullOrEmpty()) {
                binding.description.gone()
            } else {
                binding.description.visible()
            }

        }
    }

    fun setData(list: ArrayList<BoardModel>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}