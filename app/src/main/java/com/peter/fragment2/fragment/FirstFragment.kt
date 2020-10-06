package com.peter.fragment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.peter.fragment2.R
import com.peter.fragment2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    //뷰을 바인딩해서 다가지고온다.
    private lateinit var binding: FragmentFirstBinding
    //뷰를 생성한다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_first,
            container,
            true
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.apply {
            title.setOnClickListener {
                Toast.makeText(requireContext(),"This is ${title.text} fragment",Toast.LENGTH_SHORT).show()

            }

        }
    }


}