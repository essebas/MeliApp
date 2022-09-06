package com.example.core_data.error

const val ERROR_404 = "404"
const val ERROR_400 = "400"
const val ERROR_503 = "503"

abstract class ErrorManager(val code: String)