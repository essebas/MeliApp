package com.example.core_data.error

sealed class Data<out R> {
    data class Success<out T>(val data: T?) : Data<T>()
    data class Error(val errorManager: ErrorManager) : Data<Nothing>()
}
