package lotto.service

import lotto.model.LottoNumber
import lotto.model.Ticket

class DefaultStatisticsCalculator : StatisticsCalculator {
    override fun calculateStats(
        tickets: List<Ticket>, winningNumbers: List<LottoNumber>, bonusNumber: LottoNumber
    ): Map<Rank, Int> {
        val winStats = mutableMapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0,
            Rank.MISS to 0,
        )
        for (ticket in tickets) {
            val match = ticket.numbers.count { winningNumbers.contains(it) }
            val rank = if (match == 5 && ticket.numbers.contains(bonusNumber)) {
                Rank.SECOND
            } else {
                Rank.valueOf(match, false)
            }
            winStats.put(rank, winStats.getOrDefault(rank, 0) + 1)
        }
        return winStats
    }

    override fun calculateReturnRate(
        amount: Int, winStats: Map<Rank, Int>
    ): String {
        val totalReturn = winStats.entries.sumOf { (rank, count) -> rank.prize * count }
        val returnRate = totalReturn.toDouble() / amount
        return String.format("%.2f", returnRate)
    }
}


