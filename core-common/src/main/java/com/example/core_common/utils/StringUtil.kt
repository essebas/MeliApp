package com.example.core_common.utils

import java.text.DecimalFormat
import java.text.NumberFormat

object StringUtil {
    const val EMPTY_STRING = ""

    fun getMoneyFormat(value: Int): String {
        val numberFormat = NumberFormat.getCurrencyInstance()
        numberFormat.minimumFractionDigits = 0
        return numberFormat.format(value)
    }

    fun getNumberDecimalFormat(value: Int) = String.format("%,d", value)
}