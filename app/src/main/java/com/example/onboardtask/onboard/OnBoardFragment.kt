package com.example.onboardtask.onboard

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onboardtask.R
import com.example.onboardtask.base.BaseFragment
import com.example.onboardtask.data.local.preferences.PreferencesHelper
import com.example.onboardtask.databinding.FragmentOnBoardBinding
import com.example.onboardtask.onboard.model.BoardModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardFragment : BaseFragment<FragmentOnBoardBinding>(R.layout.fragment_on_board) {
    override val binding by viewBinding(FragmentOnBoardBinding::bind)

    @Inject
    lateinit var preferences: PreferencesHelper

    private val viewPagerAdapter = ViewPagerAdapter(this::onItemClick)
    override fun initialize() {
        checkIfOnBoardHasBeenShown()
    }

    private fun checkIfOnBoardHasBeenShown() {
        if (preferences.hasOnBoardBeenShown)
            findNavController().navigate(R.id.homeFragment)

    }

    override fun setupListeners() {
        binding.pager.setOnClickListener {
            binding.pager.setCurrentItem(binding.pager.currentItem + 1, true)
        }
    }

    override fun assembleViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.pager.adapter = viewPagerAdapter
        viewPagerAdapter.setData(list = getBoardList())
        binding.dotsIndicator.setViewPager2(binding.pager)
    }

    private fun getBoardList(): ArrayList<BoardModel> {
        val list: ArrayList<BoardModel> = arrayListOf()
        list.add(
            BoardModel(
                R.drawable.start,
                "GeekMessage",
                "Добро пожаловать в GeekMessage",
                "NEXT"
            )
        )
        list.add(
            BoardModel(
                R.drawable.second, "Описание", "Отличный и удобный messanger",
                "NEXT"
            )
        )
        list.add(
            BoardModel(
                R.drawable.finish,
                " Погнали",
                "Скорее нажимай на кнопку",
                "START"
            )
        )

        return list
    }

    private fun onItemClick(position: Int) {

        when (position) {
            0 -> {
                binding.pager.setCurrentItem(1, true)
            }
            1 -> {
                binding.pager.setCurrentItem(2, true)
            }
            2 -> {

                preferences.hasOnBoardBeenShown = true
                findNavController().navigate(R.id.homeFragment)
            }
        }


    }


}
