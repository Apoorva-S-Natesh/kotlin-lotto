package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TicketTest {
    @Test
    fun `ticket numbers are not equal to 6 throws exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            Ticket(listOf(10, 2, 34, 5, 2, 15, 6))
        }
        assertThat(exception.message).isEqualTo("Need ${Constants.NUMBER_COUNT} numbers")
    }

    @Test
    fun `ticket numbers are equal to 6 does not throw exception`() {
        val ticket = assertDoesNotThrow {
            Ticket(listOf(1, 2, 34, 6, 45, 41))
        }
        assertThat(ticket.numbers).hasSize(Constants.NUMBER_COUNT)
    }

    @Test
    fun `ticket numbers not in the range throws exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            Ticket(listOf(1, 2, 34, 46, 4, 41))
        }
        assertThat(exception.message).isEqualTo("Numbers should be between ${Constants.MINIMUM_NUMBER} to ${Constants.MAXIMUM_NUMBER}")
    }

    @Test
    fun `ticket numbers in the range does not throw exception`() {
        val ticket =  assertDoesNotThrow {
            Ticket(listOf(1, 2, 34, 6, 45, 41))
        }
        assertThat(ticket.numbers).allMatch { it in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER }
    }

    @Test
    fun `ticket numbers are duplicate throws exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            Ticket(listOf(1, 1, 2, 3, 4, 5))
        }
        assertThat(exception.message).isEqualTo("Numbers have to be distinct")
    }

    @Test
    fun `ticket numbers are not duplicate does not throw exception`() {
        val ticket = assertDoesNotThrow {
            Ticket(listOf(1, 10, 2, 3, 4, 5))
        }
        assertThat(ticket.numbers.size).isEqualTo(ticket.numbers.distinct().size)
    }

    @Test
    fun `ticket numbers should not be empty`() {
        val exception =  assertThrows<IllegalArgumentException> {
            Ticket(emptyList())
        }
        assertThat(exception.message).isEqualTo("Need ${Constants.NUMBER_COUNT} numbers" )
    }
}
