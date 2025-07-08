package lotto.view

import lotto.model.LottoNumber
import lotto.service.Constants

object InputView {
    fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = readln().trim().toInt()
                return amount
            } catch (_: NumberFormatException) {
                println("Amount must be a number")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid amount")
            }
        }
    }

    fun inputWinningNumbers(): List<LottoNumber> {
        println("\nPlease enter last week’s winning numbers.")
        while (true) {
            try {
                val input = readln().trim()
                val numbers = input.split(",").map { LottoNumber.Companion.from(it.trim().toInt()) }
                require(numbers.size == Constants.NUMBER_COUNT) { "Numbers have to be distinct" }
                require(numbers.toSet().size == Constants.NUMBER_COUNT) { "Numbers have to be distinct" }
                return numbers
            } catch (_: NumberFormatException) {
                println("Winning number should  be a numeric")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid winning number")
            }
        }
    }

    fun inputBonusNumber(numberList: List<LottoNumber>): LottoNumber {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonusNumber = LottoNumber.Companion.from(readln().trim().toInt())
                require(bonusNumber !in numberList) { "Bonus number should be different from winning numbers" }
                return bonusNumber
            } catch (_: NumberFormatException) {
                println("bonus Number must be a numeric")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid bonus number")
            }
        }
    }

    fun inputManualTicketCount(): Int {
        while (true) {
            try {
                println("\nEnter the number of manual tickets to purchase.")
                val manualTicketCount = readln().trim().toInt()
                return manualTicketCount
            } catch (_: NumberFormatException) {
                println("Number of manual tickets should be numeric")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid number")
            }
        }
    }

    fun inputManualTicketNumbers(manualTicketCount: Int): List<String> {
        while (true) {
            if (manualTicketCount != 0) {
                println("\nEnter the numbers for manual tickets.")
            }
            val manualTicketList = mutableListOf<String>()
            repeat(manualTicketCount) {
                val manualTicket = readln()
                manualTicketList.add(manualTicket)
            }
            return manualTicketList
        }
    }
}
