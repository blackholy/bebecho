package kr.co.eoasis.bebecho.util

sealed class State<out T> {
    object Loading : State<Nothing>()

    data class Error(val errorMessage: String) : State<Nothing>()

    data class Success<out T>(val data: T) : State<T>()
}
