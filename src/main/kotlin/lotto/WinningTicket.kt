package lotto

class WinningTicket(val winningNumbers: List<Int>, val bonusNumber: Int = 1) {
    init {
        require(winningNumbers.size == Constants.NUMBER_COUNT) { "There should be ${Constants.NUMBER_COUNT} winning numbers" }
        require(
            winningNumbers.all {
                it in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER
            },
        ) { " Winning numbers should be between ${Constants.MINIMUM_NUMBER} to ${Constants.MAXIMUM_NUMBER} " }
        require(winningNumbers.toSet().size == Constants.NUMBER_COUNT) { " Winning numbers should be unique " }
        require(bonusNumber in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER) {
            "Bonus number should be between ${Constants.MINIMUM_NUMBER}..${Constants.MAXIMUM_NUMBER}"
        }
        require(bonusNumber !in winningNumbers) { "Bonus number should be different from winning numbers" }
    }
}
