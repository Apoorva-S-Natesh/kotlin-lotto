package lotto.model

import lotto.service.Constants

class WinningTicket(val winningNumbers: Ticket, val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber.toInt() in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER) {
            "Bonus number should be between ${Constants.MINIMUM_NUMBER}..${Constants.MAXIMUM_NUMBER}"
        }
        require(bonusNumber !in winningNumbers.numbers) { "Bonus number should be different from winning numbers" }
    }
}