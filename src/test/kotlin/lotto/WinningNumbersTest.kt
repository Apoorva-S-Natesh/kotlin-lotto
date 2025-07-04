package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `winning numbers in range 1 to 45`() {
        assertDoesNotThrow {
            val ticket = WinningTicket(listOf(10, 2, 3, 4, 5, 6))
            require(ticket.winningNumbers.all { it in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER })
        }
    }

    @Test
    fun `winning numbers not in range 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            val ticket = WinningTicket(listOf(10, 2, 3, 54, 5, 6))
            require(ticket.winningNumbers.all { it in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER })
        }
    }

    @Test
    fun `winning numbers are unique`() {
        assertDoesNotThrow {
            val ticket = WinningTicket(listOf(10, 2, 34, 45, 5, 13))
            require(ticket.winningNumbers.toSet().size == Constants.NUMBER_COUNT)
        }
    }

    @Test
    fun `winning numbers are not unique`() {
        assertThrows<IllegalArgumentException> {
            val ticket = WinningTicket(listOf(10, 2, 34, 5, 2, 13))
            require(ticket.winningNumbers.toSet().size == Constants.NUMBER_COUNT)
        }
    }

    @Test
    fun `size winning numbers are not 6`() {
        assertThrows<IllegalArgumentException> {
            val ticket = WinningTicket(listOf(10, 2, 34, 5, 2))
            require(ticket.winningNumbers.size == Constants.NUMBER_COUNT)
        }
    }

    @Test
    fun `size winning numbers are  6`() {
        assertDoesNotThrow {
            val ticket = WinningTicket(listOf(10, 2, 34, 45, 5, 13))
            require(ticket.winningNumbers.size == Constants.NUMBER_COUNT)
        }
    }

    @Test
    fun `bonus number is in the range 1 to 45`() {
        assertDoesNotThrow {
            val ticket = WinningTicket(listOf(1, 2, 34, 45, 5, 13), 11)
            require(ticket.bonusNumber in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER)
        }
    }

    @Test
    fun `bonus number is not in the range 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            val ticket = WinningTicket(listOf(10, 2, 34, 45, 5, 13), 100)
            require(ticket.bonusNumber in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER)
        }
    }

    @Test
    fun `bonus number not in the list of winning numbers`() {
        assertDoesNotThrow {
            val ticket = WinningTicket(listOf(1, 2, 3, 4, 5, 6), 11)
            require(ticket.bonusNumber !in ticket.winningNumbers)
        }
    }

    @Test
    fun `bonus number in the list of winning numbers`() {
        assertThrows<IllegalArgumentException> {
            val ticket = WinningTicket(listOf(1, 2, 3, 4, 5, 6), 2)
            require(ticket.bonusNumber !in ticket.winningNumbers)
        }
    }
}
