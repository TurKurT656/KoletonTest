package com.example.koletontest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val data = MutableLiveData<List<Itemm>>()

    val loading = MutableLiveData(true)

    init {
        viewModelScope.launch {
            delay(5000)
            data.value = listOf(
                Itemm(1),
                Itemm(2),
                Itemm(3),
                Itemm(4),
                Itemm(5)
            )
            loading.value = false
        }
    }


}