package lotto

object InputView {
    fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = readln().trim().toInt()
                require(amount >= Const.PRICE && amount % Const.PRICE == 0) { Const.AMOUNT_ERROR }
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
                require(numbers.size == Const.NUMBER_COUNT) { Const.DISTINCT_NUM }
                require(numbers.toSet().size == Const.NUMBER_COUNT) { Const.DISTINCT_NUM }
                require(numbers.all { it in Const.MIN..Const.MAX }) { Const.NUM_RANGE }
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
                require(bonusNumber in Const.MIN..Const.MAX) { Const.NUM_RANGE }
                require(bonusNumber !in numberList) { Const.DISTINCT_NUM }
                return bonusNumber
            } catch (_: NumberFormatException) {
                println("bonus Number must be a numeric")
            } catch (_: IllegalArgumentException) {
                println("Enter a valid bonus number")
            }
        }
    }
}
