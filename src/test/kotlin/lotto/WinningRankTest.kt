package lotto

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WinningRankTest {
    @Test
    fun `return FIRST when 6 numbers match`() {
        val rank = Rank.valueOf(6, false)
        assertEquals(rank, Rank.FIRST)
    }

    @Test
    fun `return SECOND when 5 numbers match and bonus`() {
        val rank = Rank.valueOf(5, true)
        assertEquals(rank, Rank.SECOND)
    }

    @Test
    fun `return SECOND when 5 numbers match without bonus`() {
        val rank = Rank.valueOf(5, false)
        assertEquals(rank, Rank.THIRD)
    }

    @Test
    fun `return THIRD when 4 numbers match`() {
        val rank = Rank.valueOf(4, false)
        assertEquals(rank, Rank.FOURTH)
    }

    @Test
    fun `return FOURTH when 3 numbers match`() {
        val rank = Rank.valueOf(3, false)
        assertEquals(rank, Rank.FIFTH)
    }
}
