package lotto.service

object AmountValidator {
    fun validate(amount: Int) {
        require(amount >= Constants.TICKET_PRICE) { "Amount should be greater than or equal to ${Constants.TICKET_PRICE}" }
        require(amount % Constants.TICKET_PRICE == 0) { "Amount should be divisible by ${Constants.TICKET_PRICE}" }
    }
}