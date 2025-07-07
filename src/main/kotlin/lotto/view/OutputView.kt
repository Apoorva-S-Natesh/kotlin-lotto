package lotto.view

import lotto.service.Rank
import lotto.model.Ticket
import java.text.NumberFormat

object OutputView {
    fun displayTickets(
        ticketCount: Int,
        ticketsList: List<Ticket>,
        manualTicketCount: Int,
    ) {
        println("\nPurchased $manualTicketCount manual and $ticketCount automatic tickets.")
        ticketsList.forEach { ticket ->
            println(ticket.numbers.joinToString(prefix = "[", postfix = "]", separator = ","))
        }
    }

    fun displayResults(
        winStats: Map<Rank, Int>,
        returnRate: String,
    ) {
        val text =
            """
            
            Winning Statistics
            ------------------
            3 Matches (${formatNumber(Rank.FIFTH.prize)} KRW) - ${winStats[Rank.FIFTH]} tickets
            4 Matches (${formatNumber(Rank.FOURTH.prize)} KRW) - ${winStats[Rank.FOURTH]} tickets
            5 Matches (${formatNumber(Rank.THIRD.prize)} KRW) - ${winStats[Rank.THIRD]} tickets
            5 Matches + Bonus Ball (${formatNumber(Rank.SECOND.prize)} KRW) - ${winStats[Rank.SECOND]} tickets
            6 Matches (${formatNumber(Rank.FIRST.prize)} KRW) - ${winStats[Rank.FIRST]} tickets
            Total return rate is $returnRate (A rate below 1 means a loss)
            """.trimIndent()
        println(text)
    }

    private fun formatNumber(prizeAmount: Int): String {
        return NumberFormat.getNumberInstance().format(prizeAmount)
    }
}