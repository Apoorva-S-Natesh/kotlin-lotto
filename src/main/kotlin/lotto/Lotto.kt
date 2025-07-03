package lotto

class Lotto(val amount: Int) {
    init {
        require(amount <= Const.PRICE) { "Amount should be greater than or equal to ${Const.PRICE}" }
        require(amount % Const.PRICE == 0) { "Amount should be divisible by ${Const.PRICE}" }
    }
}
