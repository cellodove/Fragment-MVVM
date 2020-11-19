package com.peter.fragment2.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.peter.fragment2.R
import com.peter.fragment2.databinding.ActivityMainBinding
import com.peter.fragment2.mainfragment.FirstFragment
import com.peter.fragment2.mainfragment.SecondFragment
import com.peter.fragment2.mainfragment.ThirdFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //왜 by viewModels 로하는지 확인하기
    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //액션 뷰모델로 보낸다.
        setListener()

        //액션에서 변한데이터를 바라본다.
        setObserver()
    }

    private fun setListener() {
        binding.apply {
            //네비게이션바 내부버튼 누를시 액션 이것때문에 계속 애러난거였어.....
            bottomNavigation.setOnNavigationItemReselectedListener {
                val fragmentNumber:Fragment = getFragmentNumber(it.itemId)
                viewModel.changeFragment(fragmentNumber)

                return@setOnNavigationItemReselectedListener
            }
        }
    }
    //네비게이션바에서 아이디를 받아온다.
    private fun getFragmentNumber(id:Int): Fragment =
        when(id){
            R.id.first -> FirstFragment()
            R.id.second -> SecondFragment()
            R.id.third -> ThirdFragment()
            else -> FirstFragment()
        }


    private fun setObserver() {
        viewModel.apply {
            fragmentNumber.observe(
                //따라갈 라이프사이클?
                this@MainActivity,
                Observer {
                    showFragment(it)
                }
            )
        }

    }

    private fun showFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(binding.fragmentView.id,fragment).commit()
    }







}