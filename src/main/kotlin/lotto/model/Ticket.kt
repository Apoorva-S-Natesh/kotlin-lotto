package lotto.model

import lotto.service.Constants

class Ticket(val numbers: List<LottoNumber>) {
    init {
        require(
            numbers.size == Constants.NUMBER_COUNT,
        ) { "Need ${Constants.NUMBER_COUNT} numbers" }
        require(
            numbers.distinct().size == Constants.NUMBER_COUNT,
        ) { "Numbers have to be distinct" }
    }
}