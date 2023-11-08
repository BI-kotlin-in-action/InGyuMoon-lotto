package view

import java.util.SortedSet

class InputView {
    companion object {
        private const val COMMA_DELIMITER = ","
        private const val LOTTO_PRICE_PER_TICKET = 1000
        fun getLottoPurchaseAmount(): Int {
            val input = readln().toInt()
            return input / LOTTO_PRICE_PER_TICKET
        }

        fun getManualLottoAmount(): Int {
            return readln().toInt()
        }

        fun getManualLottoTicket(): SortedSet<Int> {
            return readln().split(COMMA_DELIMITER).map { it.toInt() }.toSortedSet()
        }
    }
}
