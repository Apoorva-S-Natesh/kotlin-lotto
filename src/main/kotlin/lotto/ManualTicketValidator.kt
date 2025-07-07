package lotto

object ManualTicketValidator {
    fun checkTicketCount (count: Int, amount:Int) {
        val totalPossiblePurchase = amount / Constants.TICKET_PRICE
        require(count <= totalPossiblePurchase) { "Manual tickets cannot be more than the possible purchase" }
    }
}