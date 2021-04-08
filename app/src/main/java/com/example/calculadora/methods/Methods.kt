package com.example.calculadora.methods

import java.text.DecimalFormat
import java.util.*

interface Methods {

    fun checkExpressionLength(expression: String): Boolean {
        return expression.length < 10
    }

    fun alreadyHasMathSymbol(expression: String): Boolean {
        for (i in 0 until expression.length) {
            val charIndex = Character.toString(expression[i])
            if (charIndex == "+" || charIndex == "-" || charIndex == "x" || charIndex == "÷") {
                return true
            }
        }
        return false
    }

    fun countCharacters(word: String, character: String): Int {
        var result = 0
        for (i in 0 until word.length) {
            val charIndex = Character.toString(word[i])
            if (charIndex == character) {
                result++
            }
        }
        return result
    }

    fun checkingDecimals(expression: String): Boolean {
        if (countCharacters(expression, ".") >= 3) {
            return false
        }
        var checkDots = 0
        for (i in 0 until expression.length) {
            val charIndex = Character.toString(expression[i])
            if (charIndex == "+" || charIndex == "-" || charIndex == "x" || charIndex == "÷" || checkDots >= 1) {
                if (countCharacters(expression.substring(0, i), ".") >= 2 || countCharacters(
                        expression.substring(i),
                        "."
                    ) >= 2
                ) {
                    return false
                }
            }
            if (charIndex == ".") {
                if (Character.toString(expression[i + 1]) == ".") {
                    return false
                }
                checkDots++
            }
        }
        return true
    }

    fun checkNumber(expression: String): Double {
        var number = "0"
        for (i in 0 until expression.length) {
            val charIndex = Character.toString(expression[i])
            number += if (charIndex == "+" || charIndex == "-" || charIndex == "x" || charIndex == "÷") {
                break
            } else {
                charIndex
            }
        }
        return number.toDouble()
    }

    fun calculate(expression: String): String? {
        Locale.setDefault(Locale("en", "US"))
        val format = DecimalFormat("#0.00")
        var result = 0.0
        var numberActual = "0"
        if (expression == numberActual) {
            return expression
        }
        for (i in 0 until expression.length) {
            val charIndex = Character.toString(expression[i])
            if (charIndex == "+") {
                if (i == expression.lastIndex) {
                    return numberActual
                }
                result = checkNumber(numberActual) + checkNumber(expression.substring(i + 1))
            } else if (charIndex == "-") {
                if (i == expression.lastIndex) {
                    return numberActual
                }
                result = checkNumber(numberActual) - checkNumber(expression.substring(i + 1))
            } else if (charIndex == "x") {
                if (i == expression.lastIndex) {
                    return numberActual
                }
                result = checkNumber(numberActual) * checkNumber(expression.substring(i + 1))
            } else if (charIndex == "÷") {
                if (i == expression.lastIndex) {
                    return numberActual
                }
                result = checkNumber(numberActual) / checkNumber(expression.substring(i + 1))
            } else {
                numberActual += charIndex
            }
        }
        return format.format(result)
    }

    fun porcentage(expression: String): String? {
        val format = DecimalFormat("#0.00")
        var result = 0.00
        var numberActual: String? = "0"
        for (i in 0 until expression.length) {
            val charIndex = Character.toString(expression[i])
            if (charIndex == "+") {
                return "0"
            } else if (charIndex == "-") {
                return "0"
            } else if (charIndex == "x") {
                result =
                    checkNumber(numberActual!!) * (checkNumber(expression.substring(i + 1)) / 100)
            } else if (charIndex == "÷") {
                return "0"
            } else {
                numberActual += charIndex
            }
        }
        return format.format(result)
    }


}
