package lotto

class Ticket(val numbers: List<Int>) {
    init {
        require(numbers.size == 6 && numbers.distinct().size == 6) { "Numbers have to be distinct" }
        require(numbers.all { it in 1..45 }) { "Numbers should be between 1 to 45" }
    }
}
