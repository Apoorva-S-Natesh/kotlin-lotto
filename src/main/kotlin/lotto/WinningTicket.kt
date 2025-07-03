package lotto

class WinningTicket(val winningNumbers: List<Int>, val bonusNumber: Int = 1) {
    init {
        require(winningNumbers.size == 6) { "There should be 6 winning numbers" }
        require(winningNumbers.all { it in 1..45 }) { " Winning numbers should be between 1 to 45 " }
        require(winningNumbers.toSet().size == 6) { " Winning numbers should be unique " }
        require(bonusNumber in 1..45) { "Bonus number should be between 1 to 45" }
        require(bonusNumber !in winningNumbers) { "Bonus number should be different from winning numbers" }
    }
}
