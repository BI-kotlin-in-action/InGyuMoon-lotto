package domain

class LottoGenerator {
    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val SUBLIST_START_INDEX = 0
        private const val SUBLIST_END_INDEX = 6
        fun makeLottoTickets(lottoPurchaseAmount: Int): LottoTickets {
            val lottoTickets = mutableListOf<Lotto>()
            repeat(lottoPurchaseAmount) {
                lottoTickets.add(generateLottoNumbers())
            }
            return LottoTickets(lottoTickets)
        }
        private fun generateLottoNumbers(): Lotto {
            val numbers: Set<Int> = (MIN_NUMBER..MAX_NUMBER).toSet()
            return Lotto(numbers.shuffled().subList(SUBLIST_START_INDEX, SUBLIST_END_INDEX).toSortedSet())
        }
    }
}
