package com.example.sunrinsocialnetwork

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _bottomNavigationPosition = MutableLiveData<Int>()
    val bottomNavigationPosition : LiveData<Int>
        get() = _bottomNavigationPosition

    fun changePosition(position : Int) {
        Log.d(ContentValues.TAG, "changePosition: click button")
        _bottomNavigationPosition.value = position
    }


    val changePosition : (Int) -> Unit = {position -> changePosition(position)}

}