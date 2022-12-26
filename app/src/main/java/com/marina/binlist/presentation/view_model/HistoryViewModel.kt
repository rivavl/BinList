package com.marina.binlist.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.binlist.domain.use_case.GetHistory
import com.marina.binlist.domain.util.Resource
import com.marina.binlist.presentation.entity.ListState
import com.marina.binlist.presentation.mapper.toUI
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val getHistory: GetHistory
) : ViewModel() {

    private val _cardsList = MutableLiveData<ListState>()
    val cardsList: LiveData<ListState> get() = _cardsList

    init {
        getCards()
    }

    private fun getCards() = viewModelScope.launch {
        getHistory().collect { resultsList ->
            when (resultsList) {
                is Resource.Success -> {
                    _cardsList.value = ListState(
                        data = resultsList.data?.toUI()!!,
                        isLoading = false,
                        hasError = false
                    )
                }

                is Resource.Loading -> {
                    _cardsList.value = ListState(
                        data = null,
                        isLoading = true,
                        hasError = false
                    )
                }

                is Resource.Error -> {
                    _cardsList.value = ListState(
                        data = null,
                        isLoading = false,
                        hasError = true
                    )
                }
            }

        }
    }
}