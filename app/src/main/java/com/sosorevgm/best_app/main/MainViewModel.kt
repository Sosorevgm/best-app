package com.sosorevgm.best_app.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sosorevgm.best_app.models.Price
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val MAX_PRICE_COUNT = 50

class MainViewModel(
    private val repository: MainRepository,
) : ViewModel() {
    private val list: MutableList<Price> = mutableListOf()

    private val _ld = MutableLiveData<List<Price>>()
    val ld: LiveData<List<Price>> = _ld

    init {
        viewModelScope.launch { startFetchingData() }
    }

    private suspend fun startFetchingData() {
        val price = repository.getPriceAsync().await()
        list.add(0, price)
        _ld.postValue(list.take(MAX_PRICE_COUNT))
        delay(60)
        startFetchingData()
    }
}
