package lotto.controller

import lotto.model.ManualTicket
import lotto.model.Ticket
import lotto.service.AmountValidator
import lotto.view.InputView

object InputHandler {
    fun getAmountInput(): Int {
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

    fun getManualTicketCount(amount: Int): Int {
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

    fun getManualTickets(manualTicketCount: Int): List<Ticket> {
        while (true) {
            try {
                val manualTicketsString = InputView.inputManualTicketNumbers(manualTicketCount)
                return ManualTicket.generateManualTickets(manualTicketsString)
            } catch (_: IllegalArgumentException) {
                println("Enter valid manual tickets")
            }
        }
    }
}
