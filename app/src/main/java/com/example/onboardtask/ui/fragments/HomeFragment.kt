package com.example.onboardtask.ui.fragments

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onboardtask.R
import com.example.onboardtask.base.BaseFragment
import com.example.onboardtask.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
}
