package lotto.service

enum class Rank(val prize: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    MISS(0),
    ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean,
        ): Rank {
            return when {
                countOfMatch == 6 -> FIRST
                countOfMatch == 5 && matchBonus -> SECOND
                countOfMatch == 5 && !matchBonus -> THIRD
                countOfMatch == 4 -> FOURTH
                countOfMatch == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}