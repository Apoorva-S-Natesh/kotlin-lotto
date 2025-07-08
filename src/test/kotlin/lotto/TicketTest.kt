package lotto

import lotto.model.LottoNumber
import lotto.model.Ticket
import lotto.service.Constants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TicketTest {
    private fun numberToLottoNumber(vararg values: Int) = values.map(LottoNumber::from)

    @Test
    fun `ticket numbers are not equal to 6 throws exception`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Ticket(numberToLottoNumber(10, 2, 34, 5, 2, 15, 6))
            }
        assertThat(exception).hasMessage("Need ${Constants.NUMBER_COUNT} numbers")
    }

    @Test
    fun `ticket numbers are equal to 6 does not throw exception`() {
        val ticket =
            assertDoesNotThrow {
                Ticket(numberToLottoNumber(1, 2, 34, 6, 45, 41))
            }
        assertThat(ticket.numbers).hasSize(Constants.NUMBER_COUNT)
    }

    @Test
    fun `ticket numbers not in the range throws exception`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Ticket(numberToLottoNumber(1, 2, 34, 46, 4, 41))
            }
        assertThat(exception).hasMessage("Numbers must be between ${Constants.MINIMUM_NUMBER} and ${Constants.MAXIMUM_NUMBER}")
    }

    @Test
    fun `ticket numbers in the range does not throw exception`() {
        val ticket =
            assertDoesNotThrow {
                Ticket(numberToLottoNumber(1, 2, 34, 6, 45, 41))
            }
        assertThat(ticket.numbers).allMatch { it.toInt() in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER }
    }

    @Test
    fun `ticket numbers are duplicate throws exception`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Ticket(numberToLottoNumber(1, 1, 2, 3, 4, 5))
            }
        assertThat(exception).hasMessage("Numbers have to be distinct")
    }

    @Test
    fun `ticket numbers are not duplicate does not throw exception`() {
        val ticket =
            assertDoesNotThrow {
                Ticket(numberToLottoNumber(1, 10, 2, 3, 4, 5))
            }
        assertThat(ticket.numbers.size).isEqualTo(ticket.numbers.distinct().size)
    }

    @Test
    fun `ticket numbers should not be empty`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Ticket(emptyList())
            }
        assertThat(exception).hasMessage("Need ${Constants.NUMBER_COUNT} numbers")
    }
}
