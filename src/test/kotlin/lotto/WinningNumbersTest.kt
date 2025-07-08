package lotto

import lotto.model.LottoNumber
import lotto.model.Ticket
import lotto.model.WinningTicket
import lotto.service.Constants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    private fun numberToLottoNumber(vararg values: Int) = values.map(LottoNumber::from)

    @Test
    fun `bonus number is in winning numbers throws exception`() {
        val ticket = Ticket(numberToLottoNumber(1, 2, 34, 45, 5, 13))
        val exception =
            assertThrows<IllegalArgumentException> {
                WinningTicket(ticket, LottoNumber.from(2))
            }
        assertThat(exception).hasMessage("Bonus number should be different from winning numbers")
    }

    @Test
    fun `bonus number out of valid range throws exception`() {
        val ticket = Ticket(numberToLottoNumber(1, 2, 34, 45, 5, 13))
        val exception =
            assertThrows<IllegalArgumentException> {
                WinningTicket(ticket, LottoNumber.from(55))
            }
        assertThat(exception).hasMessage("Numbers must be between ${Constants.MINIMUM_NUMBER} and ${Constants.MAXIMUM_NUMBER}")
    }

    @Test
    fun `valid winning ticket and bonus number does not throw exception`() {
        val ticket = Ticket(numberToLottoNumber(1, 22, 34, 45, 5, 13))
        val ticketWon = WinningTicket(ticket, LottoNumber.from(11))
        assertThat(ticketWon.winningNumbers).isEqualTo(ticket)
        assertThat(LottoNumber.from(11)).isEqualTo(ticketWon.bonusNumber)
    }
}
