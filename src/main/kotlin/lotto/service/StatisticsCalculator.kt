package lotto.service

import lotto.model.LottoNumber
import lotto.model.Ticket

interface StatisticsCalculator {
    fun calculateStats(
        tickets: List<Ticket>,
        winningNumbers: List<LottoNumber>,
        bonusNumber: LottoNumber,
    ): Map<Rank, Int>

    fun calculateReturnRate(amount: Int, winStats: Map<Rank, Int>): String
}
