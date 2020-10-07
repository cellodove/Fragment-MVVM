package com.peter.fragment2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _fragTypeLiveData = MutableLiveData<FragmentType>()
    val fragTypeLiveData: LiveData<FragmentType>
        get()=_fragTypeLiveData

    init {
        _fragTypeLiveData.value = FragmentType.First_FRAGMENT
    }

    fun setFragmentType(fragmentType: FragmentType){
        _fragTypeLiveData.value = fragmentType
    }


}