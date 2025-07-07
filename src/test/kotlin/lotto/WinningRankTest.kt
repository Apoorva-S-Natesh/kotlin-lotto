package lotto

import lotto.service.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningRankTest {
    @Test
    fun `return FIRST when 6 numbers match`() {
        val rank = Rank.valueOf(6, false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `return SECOND when 5 numbers match and bonus`() {
        val rank = Rank.valueOf(5, true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `return SECOND when 5 numbers match without bonus`() {
        val rank = Rank.valueOf(5, false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `return THIRD when 4 numbers match`() {
        val rank = Rank.valueOf(4, false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `return FOURTH when 3 numbers match`() {
        val rank = Rank.valueOf(3, false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }
}
