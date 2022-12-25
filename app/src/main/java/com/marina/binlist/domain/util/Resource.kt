package com.marina.binlist.domain.util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val error: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(error: String) : Resource<T>(error = error)
    class Loading<T> : Resource<T>()
}