package view

class InputView {
    fun getLottoPurchaseAmount(): Int {
        val input = readln().toInt()
        return input / 1000
    }

    fun getManualLottoAmount(): Int {
        return readln().toInt()
    }

    fun getManualLottoTicket(): List<Int> {
        return readln().split(",").map { it.toInt() }.toList().sorted()
    }
}
