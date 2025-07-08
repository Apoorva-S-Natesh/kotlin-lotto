package lotto.controller

import lotto.model.LottoNumber
import lotto.model.Ticket
import lotto.service.Constants
import lotto.service.Rank
import lotto.service.StatisticsCalculator
import lotto.service.TicketGenerator

class LottoMachine(
    private val ticketGenerator: TicketGenerator, private val statisticsCalculator: StatisticsCalculator
) {
    fun buyTickets(amount: Int, manualTickets: List<Ticket>): List<Ticket> {
        val autoTicketCount = amount / Constants.TICKET_PRICE - manualTickets.size
        val autoTickets = ticketGenerator.generateAutomaticTickets(autoTicketCount)
        return manualTickets + autoTickets
    }

    fun calculateStats(
        tickets: List<Ticket>, winningNumbers: List<LottoNumber>, bonusNumber: LottoNumber
    ): Map<Rank, Int> = statisticsCalculator.calculateStats(tickets, winningNumbers, bonusNumber)

    fun calculateReturnRate(amount: Int, winStats: Map<Rank, Int>): String =
        statisticsCalculator.calculateReturnRate(amount, winStats)
}
