package domain

class LottoGenerator {
    private val MIN_NUMBER = 1
    private val MAX_NUMBER = 45
    private val NUMBERS_TO_PICK = 6

    fun makeLottoTickets(lottoPurchaseAmount: Int): MutableList<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        for (i in 0 until lottoPurchaseAmount) {
            lottoTickets.add(generateLottoNumbers())
        }
        return lottoTickets
    }
    private fun generateLottoNumbers(): Lotto {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < NUMBERS_TO_PICK) {
            numbers.add((MIN_NUMBER..MAX_NUMBER).random())
        }
        return Lotto(numbers.sorted().toList())
    }
}
