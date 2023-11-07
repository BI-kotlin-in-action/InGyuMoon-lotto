package view

class InputView {
    private val COMMA_DELIMITER = ","
    private val LOTTO_PRICE_PER_TICKET = 1000
    fun getLottoPurchaseAmount(): Int {
        val input = readln().toInt()
        return input / LOTTO_PRICE_PER_TICKET
    }

    fun getManualLottoAmount(): Int {
        return readln().toInt()
    }

    fun getManualLottoTicket(): List<Int> {
        return readln().split(COMMA_DELIMITER).map { it.toInt() }.sorted()
    }
}
