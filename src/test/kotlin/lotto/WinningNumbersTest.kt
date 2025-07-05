package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `bonus number is in winning numbers throws exception`() {
        val ticket = Ticket(listOf(1, 2, 34, 45, 5, 13))
        val exception = assertThrows<IllegalArgumentException> {
            WinningTicket(ticket, 2)
        }
        assertThat("Bonus number should be different from winning numbers").isEqualTo(exception.message)
    }

    @Test
    fun `bonus number out of valid range throws exception`() {
        val ticket = Ticket(listOf(1, 2, 34, 45, 5, 13))
        val exception = assertThrows<IllegalArgumentException> {
            WinningTicket(ticket, 55)
        }
        assertThat("Bonus number should be between ${Constants.MINIMUM_NUMBER}..${Constants.MAXIMUM_NUMBER}").isEqualTo(
            exception.message
        )
    }

    @Test
    fun `valid winning ticket and bonus number does not throw exception`() {
        val ticket = Ticket(listOf(1, 2, 34, 45, 5, 13))
        val ticketWon = WinningTicket(ticket, 11)
        assertThat(ticketWon.winningNumbers).isEqualTo(ticket)
        assertThat(11).isEqualTo(ticketWon.bonusNumber)
    }

}
