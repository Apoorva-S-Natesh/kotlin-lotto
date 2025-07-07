package lotto

import lotto.model.ManualTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ManualTicketCountValidatorTest {
    @Test
    fun `manual ticket count is a greater than possible tickets throws exception`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                ManualTicket.checkTicketCount(4, 2200)
            }
        assertThat("Manual tickets cannot be more than the possible purchase").isEqualTo(exception.message)
    }

    @Test
    fun `manual ticket count 0 does not throw exception`() {
        assertDoesNotThrow {
            ManualTicket.checkTicketCount(0, 1000)
        }
    }
}
