package lotto

object InputView {
    fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = readln().trim().toInt()
                require(amount >= Constants.TICKET_PRICE && amount % Constants.TICKET_PRICE == 0) {
                    "Invalid amount, must be divisible by ${Constants.TICKET_PRICE}"
                }
                return amount
            } catch (_: NumberFormatException) {
                println("Amount must be a number")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid amount")
            }
        }
    }

    fun inputWinningNumbers(): List<Int> {
        println("\nPlease enter last week’s winning numbers.")
        while (true) {
            try {
                val input = readln().trim()
                val numbers = input.split(",").map { it.trim().toInt() }
                require(numbers.size == Constants.NUMBER_COUNT) { "Numbers have to be distinct" }
                require(numbers.toSet().size == Constants.NUMBER_COUNT) { "Numbers have to be distinct" }
                require(numbers.all { it in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER }) { "Numbers have to be distinct" }
                return numbers
            } catch (_: NumberFormatException) {
                println("Winning number should  be a numeric")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid winning number")
            }
        }
    }

    fun inputBonusNumber(numberList: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonusNumber = readln().trim().toInt()
                require(bonusNumber in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER) {
                    "Numbers should be between ${Constants.MINIMUM_NUMBER} and ${Constants.MAXIMUM_NUMBER}"
                }
                require(bonusNumber !in numberList) { "Numbers have to be distinct" }
                return bonusNumber
            } catch (_: NumberFormatException) {
                println("bonus Number must be a numeric")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid bonus number")
            }
        }
    }
}
