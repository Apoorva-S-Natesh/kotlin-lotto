package lotto

import lotto.service.AmountValidator
import lotto.service.Constants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class AmountValidatorTest {
    @Test
    fun `amount lesser than ticket price throws exception`() {
        val ex =
            assertThrows<IllegalArgumentException> {
                AmountValidator.validate(900)
            }
        assertThat(ex).hasMessage("Amount should be greater than or equal to ${Constants.TICKET_PRICE}")
    }

    @Test
    fun `amount not divisible by ticket price throws exception`() {
        val ex =
            assertThrows<IllegalArgumentException> {
                AmountValidator.validate(1200)
            }
        assertThat(ex).hasMessage("Amount should be divisible by ${Constants.TICKET_PRICE}")
    }

    @Test
    fun `valid amount passes validator`() {
        assertDoesNotThrow {
            AmountValidator.validate(2000)
        }
    }
}
