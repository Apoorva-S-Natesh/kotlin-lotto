package lotto.model

import lotto.service.AmountValidator
import lotto.service.Constants
import lotto.view.InputView
import lotto.view.OutputView
import lotto.service.Rank

object LottoMachine {
    fun start() {
        val amount = getAmountInput()
        val manualTicketCount = getManualTicketCount(amount)
        val manualTickets = getManualTickets(manualTicketCount)
        val automaticTickets = generateAutomaticTickets(amount, manualTicketCount)
        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber(winningNumbers)
        calculateStats(automaticTickets + manualTickets, winningNumbers, bonusNumber)
        OutputView.displayResults(winStats, calculateReturnRate(amount))
    }

    private fun getAmountInput(): Int {
        while (true) {
            try {
                val amount = InputView.inputPurchaseAmount()
                AmountValidator.validate(amount)
                return amount
            } catch (_: IllegalArgumentException) {
                println("Enter a valid amount to buy tickets")
            }
        }
    }

    private fun getManualTicketCount(amount: Int): Int {
        while (true) {
            try {
                val manualTicketCount = InputView.inputManualTicketCount()
                ManualTicket.checkTicketCount(manualTicketCount, amount)
                return manualTicketCount
            } catch (_: IllegalArgumentException) {
                println("Enter a valid manual ticket count")
            }
        }
    }

    private fun getManualTickets(manualTicketCount: Int): List<Ticket> {
        while (true) {
            try {
                val manualTicketsString = InputView.inputManualTicketNumbers(manualTicketCount)
                val manualTickets = ManualTicket.generateManualTickets(manualTicketsString)
                return manualTickets
            } catch (_: IllegalArgumentException) {
                println("Enter valid manual tickets")
            }
        }
    }

    private fun generateAutomaticTickets(
        amount: Int,
        manualTicketCount: Int,
    ): List<Ticket> {
        val ticketCount = amount / Constants.TICKET_PRICE - manualTicketCount
        val ticketsList = mutableListOf<Ticket>()
        repeat(ticketCount) {
            val ticket = Ticket(generateTicketNumbers())
            ticketsList.add(ticket)
        }
        OutputView.displayTickets(ticketCount, ticketsList, manualTicketCount)
        return ticketsList
    }

    private fun generateTicketNumbers(): List<LottoNumber> {
        return LottoNumber.takeRandom(Constants.NUMBER_COUNT)
    }

    private val winStats =
        mutableMapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0,
            Rank.MISS to 0,
        )

    private fun calculateStats(
        tickets: List<Ticket>,
        winningNumbers: List<LottoNumber>,
        bonusNumber: LottoNumber,
    ) {
        for (ticket in tickets) {
            val match = checkMatch(ticket, winningNumbers)
            if (match == 5 && ticket.numbers.contains(bonusNumber)) {
                winStats[Rank.SECOND] = winStats[Rank.SECOND]!! + 1
            } else {
                winStats[
                    Rank.valueOf(
                        match, false,
                    ),
                ] = winStats[Rank.valueOf(match, false)]!! + 1
            }
        }
    }

    private fun checkMatch(
        ticket: Ticket,
        winningNumbers: List<LottoNumber>,
    ): Int {
        return (ticket.numbers.count { winningNumbers.contains(it) })
    }

    private fun calculateReturnRate(amount: Int): String {
        return (calculateTotalReturn(amount, winStats.entries.sumOf { (rank, count) -> rank.prize * count }))
    }

    private fun calculateTotalReturn(
        amount: Int,
        totalReturn: Int,
    ): String {
        val returnRate = totalReturn.toDouble() / amount
        return String.format("%.2f", returnRate)
    }
}
