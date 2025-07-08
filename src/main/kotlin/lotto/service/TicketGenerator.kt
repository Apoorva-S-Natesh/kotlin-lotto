package lotto.service

import lotto.model.Ticket

interface TicketGenerator {
    fun generateAutomaticTickets(count: Int): List<Ticket>
}
