package com.marina.binlist.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.binlist.domain.use_case.GetCardInfoByBIN
import com.marina.binlist.domain.util.Resource
import com.marina.binlist.presentation.entity.ScreenState
import com.marina.binlist.presentation.mapper.toUI
import kotlinx.coroutines.launch
import javax.inject.Inject

class InfoViewModel @Inject constructor(
    private val getCardInfoByBIN: GetCardInfoByBIN
) : ViewModel() {

    private var _info = MutableLiveData<ScreenState>()
    val info: LiveData<ScreenState> get() = _info

    init {
        _info.value = ScreenState(info = null)
    }

    fun getInfo(bin: String) = viewModelScope.launch {
        getCardInfoByBIN(bin).collect { result ->
            when (result) {
                is Resource.Loading -> {
                    _info.value = ScreenState(isLoading = true, hasError = false)
                }
                is Resource.Success -> {
                    _info.value =
                        ScreenState(isLoading = false, hasError = false, info = result.data?.toUI())
                }
                is Resource.Error -> {
                    _info.value = ScreenState(isLoading = false, hasError = true, info = null)
                }
            }
        }
    }
}