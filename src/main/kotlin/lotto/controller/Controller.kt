package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class Controller(private val lottoMachine: LottoMachine) {
    fun start() {
        val amount = InputHandler.getAmountInput()
        val manualTicketCount = InputHandler.getManualTicketCount(amount)
        val manualTickets = InputHandler.getManualTickets(manualTicketCount)
        val allTickets = lottoMachine.buyTickets(amount, manualTickets)
        OutputView.displayTickets(allTickets.size, allTickets, manualTickets.size)
        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber(winningNumbers)
        val stats = lottoMachine.calculateStats(allTickets, winningNumbers, bonusNumber)
        val returnRate = lottoMachine.calculateReturnRate(amount, stats)
        OutputView.displayResults(stats, returnRate)
    }
}
