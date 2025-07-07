package lotto

import lotto.model.LottoNumber
import lotto.service.Constants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `Numbers in range 0 and 45 don't throw exception`() {
        val number = LottoNumber.from(1)
        assertThat(number.toInt()).isEqualTo(1)
    }

    @Test
    fun `Numbers below range throws exception`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                LottoNumber.from(-1)
            }
        assertThat(exception.message).contains("Numbers must be between")
    }

    @Test
    fun `Numbers above range throws exception`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                LottoNumber.from(100)
            }
        assertThat(exception.message).contains("Numbers must be between")
    }

    @Test
    fun `allNumbers returns full list of valid numbers`() {
        val allValidNumbers = LottoNumber.allNumbers()
        assertThat(allValidNumbers).hasSize(Constants.MAXIMUM_NUMBER)
    }
}
