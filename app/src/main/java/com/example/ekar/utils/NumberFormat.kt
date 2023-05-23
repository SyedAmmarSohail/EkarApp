package com.example.ekar.utils

import java.text.NumberFormat
import java.util.*

fun Float.numberFormatWithComma(): String {
    val numberFormat = NumberFormat.getNumberInstance(Locale.US)
    return numberFormat.format(this.toInt())
}

fun calculateMonthlyDiscount(originalPrice: Int, discountRate: Int, month: Int): Float {
    if (month == 1) return 0f
    val decrementedDiscountRate = discountRate + (month * 0.5)
    val discountAmount = originalPrice * (decrementedDiscountRate / 100)
    return discountAmount.toFloat()
}