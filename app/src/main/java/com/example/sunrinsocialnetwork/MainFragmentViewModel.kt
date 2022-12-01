package com.example.sunrinsocialnetwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunrinsocialnetwork.data.Data
import com.example.sunrinsocialnetwork.data.MealResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val repository: BoardRepositoryImpl) :
    ViewModel() {

    private val _meal = MutableLiveData<MealResponse>()
    val meal: LiveData<MealResponse>
        get() = _meal
    private val _boardList = MutableLiveData<List<Data>>()
    val boardList: LiveData<List<Data>>
        get() = _boardList

    fun getBoard() {
        viewModelScope.launch {
            val result = repository.getBoard()
            if(result.isSuccessful) {
                _boardList.postValue(result.body()!!.data)
            }
        }
    }
    fun getMealData() {
        viewModelScope.launch {
            val result = repository.getMeal()
            if(result.isSuccessful){
                _meal.postValue(result.body())
            }
        }
    }
}