package lotto.service

import lotto.model.LottoNumber
import lotto.model.Ticket

class DefaultTicketGenerator : TicketGenerator {
    override fun generateAutomaticTickets(count: Int): List<Ticket> =
        List(count) { Ticket(LottoNumber.takeRandom(Constants.NUMBER_COUNT)) }
}
