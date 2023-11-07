package domain

class LottoGenerator {
    private val MIN_NUMBER = 1
    private val MAX_NUMBER = 45
    private val SUBLIST_START_INDEX = 0
    private val SUBLIST_END_INDEX = 6

    fun makeLottoTickets(lottoPurchaseAmount: Int): MutableList<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(lottoPurchaseAmount) {
            lottoTickets.add(generateLottoNumbers())
        }
        return lottoTickets
    }
    private fun generateLottoNumbers(): Lotto {
        val numbers: List<Int> = (MIN_NUMBER..MAX_NUMBER).toList()
        return Lotto(numbers.shuffled().subList(SUBLIST_START_INDEX, SUBLIST_END_INDEX).sorted())
    }
}
