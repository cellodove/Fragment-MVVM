package com.peter.fragment2.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peter.fragment2.mainfragment.FirstFragment

class MainViewModel :ViewModel() {

    private val _fragmentNumber : MutableLiveData<Fragment> = MutableLiveData()
        val fragmentNumber: LiveData<Fragment>
        get() = _fragmentNumber

    init {
        _fragmentNumber.value = FirstFragment()
    }

    fun changeFragment(fragmentNumber : Fragment){
        _fragmentNumber.value = fragmentNumber
    }



}