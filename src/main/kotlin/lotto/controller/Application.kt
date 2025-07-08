package lotto.controller

import lotto.service.DefaultStatisticsCalculator
import lotto.service.DefaultTicketGenerator

fun main() {
    val lottoMachine = LottoMachine(
        DefaultTicketGenerator(),
        DefaultStatisticsCalculator(),
    )
    val controller = Controller(lottoMachine)
    controller.start()
}
