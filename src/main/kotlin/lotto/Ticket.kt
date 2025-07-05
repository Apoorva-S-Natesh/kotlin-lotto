package lotto

class Ticket(val numbers: List<Int>) {
    init {
        require(
            numbers.size == Constants.NUMBER_COUNT,
        ) { "Need ${Constants.NUMBER_COUNT} numbers" }
        require(
            numbers.distinct().size == Constants.NUMBER_COUNT
        ) { "Numbers have to be distinct" }
        require(numbers.all { it in Constants.MINIMUM_NUMBER..Constants.MAXIMUM_NUMBER }) {
            "Numbers should be between ${Constants.MINIMUM_NUMBER} to ${Constants.MAXIMUM_NUMBER}"
        }
    }
}
