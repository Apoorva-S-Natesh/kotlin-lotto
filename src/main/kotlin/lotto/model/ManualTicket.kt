package lotto.model

import lotto.service.Constants

object ManualTicket {
    fun checkTicketCount(
        count: Int,
        amount: Int,
    ) {
        val totalPossiblePurchase = amount / Constants.TICKET_PRICE
        require(count <= totalPossiblePurchase) { "Manual tickets cannot be more than the possible purchase" }
    }

    fun generateManualTickets(tickets: List<String>): List<Ticket> {
        val manualTickets = mutableListOf<Ticket>()
        for (ticketString in tickets) {
            val ticket = ticketString.split(",").map { LottoNumber.from(it.trim().toInt()) }
            manualTickets.add(Ticket(ticket))
        }
        return manualTickets
    }
}