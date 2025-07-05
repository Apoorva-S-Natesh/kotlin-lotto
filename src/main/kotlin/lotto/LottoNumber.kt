package lotto

class LottoNumber private constructor(private val value: Int) {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value]
                ?: throw IllegalArgumentException("Numbers must be between $MINIMUM_NUMBER and $MAXIMUM_NUMBER")
        }

        fun allNumbers(): List<LottoNumber> = NUMBERS.values.toList()
    }

    override fun equals(other: Any?): Boolean {
        return other is LottoNumber && this.value == other.value
    }

    override fun hashCode(): Int = value.hashCode()

    override fun toString(): String = value.toString()

    fun toInt(): Int = value
}
