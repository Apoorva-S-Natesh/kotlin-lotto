package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `Amount is greater than 1000`() {
        assertThrows<IllegalArgumentException> {
            val lotto = Lotto(2000)
            requireNotNull(lotto.amount >= 1000)
        }
    }

    @Test
    fun `Amount is divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            val lotto = Lotto(2000)
            require(lotto.amount / 1000 == 0)
        }
    }
}
