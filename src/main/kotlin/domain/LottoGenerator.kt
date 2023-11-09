package domain

import ConstantNumber

class LottoGenerator {
    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val numbers: List<Int> = (ConstantNumber.MIN_NUMBER..ConstantNumber.MAX_NUMBER).toList()
        fun makeLottoTickets(lottoPurchaseAmount: Int): LottoTickets {
            val lottoTickets = mutableListOf<Lotto>()
            repeat(lottoPurchaseAmount) {
                lottoTickets.add(generateLottoNumbers())
            }
            return LottoTickets(lottoTickets)
        }
        private fun generateLottoNumbers(): Lotto {
            return Lotto(numbers.shuffled().take(LOTTO_NUMBER_COUNT).toSortedSet())
        }
    }
}
