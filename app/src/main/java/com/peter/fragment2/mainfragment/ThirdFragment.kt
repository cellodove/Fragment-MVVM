package com.peter.fragment2.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.peter.fragment2.R
import com.peter.fragment2.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(){

    //바인딩하고
    private lateinit var binding: FragmentThirdBinding

    //뷰생성하고
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_third,
            container,
            true
        )
        return binding.root
    }

}