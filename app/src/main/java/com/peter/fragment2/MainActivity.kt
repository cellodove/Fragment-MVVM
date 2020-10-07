package com.peter.fragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.peter.fragment2.databinding.ActivityMainBinding
import com.peter.fragment2.fragment.FirstFragment
import com.peter.fragment2.fragment.SecondFragment
import com.peter.fragment2.fragment.ThirdFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    private val fragList = listOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setListener()
        setObserver()

    }


    private fun setListener() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            val position = getFragmentType(it.itemId)
            viewModel.setFragmentType(position)

            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun getFragmentType(id:Int): FragmentType =
        when(id){
            R.id.first -> FragmentType.First_FRAGMENT
            R.id.second -> FragmentType.SECOND_FRAGMENT
            R.id.third -> FragmentType.THIRD_FRAGMENT
            else -> FragmentType.First_FRAGMENT
        }


    private fun setObserver() {
        viewModel.apply {
            fragTypeLiveData.observe(
                this@MainActivity,
                Observer {
                    val fragment = getFragmentByPosition(it.position)
                    showFragment(fragment)

                }
            )
        }
    }

    private fun getFragmentByPosition(position: Int):Fragment = fragList[position]

    private fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(binding.frame.id,fragment).commit()
    }
}