package com.example.sunrinsocialnetwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunrinsocialnetwork.data.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepositoryImpl) :
    ViewModel() {
    val searchText = MutableLiveData<String>()

    private val _boardList = MutableLiveData<List<Data>>()
    val boardList: LiveData<List<Data>>
        get() = _boardList


    fun search() {
        viewModelScope.launch {
            _boardList.postValue(listOf())
            if(searchText.value != null){
                val result = repository.search(searchText.value!!)
                if (result.isSuccessful) {
                    _boardList.postValue(result.body()!!.data)
                }
            }
        }
    }
}