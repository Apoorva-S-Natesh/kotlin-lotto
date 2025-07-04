package lotto

object OutputView {
    fun displayTickets(
        ticketCount: Int,
        ticketsList: List<Ticket>,
    ) {
        println("You have purchased $ticketCount tickets.")
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
        return prizeAmount.toString().reversed().chunked(3).joinToString(",").reversed()
    }
}
