package view

import java.util.SortedSet

class InputView {
    companion object {
        private const val COMMA_DELIMITER = ","
        private const val LOTTO_PRICE_PER_TICKET = 1000
        fun getValidLottoPurchaseAmount(): Int {
            while (true) {
                try {
                    return getLottoPurchaseAmount()
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
        private fun getLottoPurchaseAmount(): Int {
            val validInput = checkIntegerFormat(readln())
            checkMinimumAmount(validInput)
            return validInput / LOTTO_PRICE_PER_TICKET
        }

        private fun checkMinimumAmount(validInput: Int) {
            if (validInput < LOTTO_PRICE_PER_TICKET) {
                throw IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하세요.")
            }
        }

        fun getValidManualLottoAmount(lottoPurchaseAmount: Int): Int {
            while (true) {
                try {
                    return getManualLottoAmount(lottoPurchaseAmount)
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
        private fun getManualLottoAmount(lottoPurchaseAmount: Int): Int {
            val validInput = checkIntegerFormat(readln())
            checkManualLottoCount(validInput, lottoPurchaseAmount)
            return validInput
        }

        private fun checkManualLottoCount(validInput: Int, lottoPurchaseAmount: Int) {
            if (lottoPurchaseAmount < validInput) {
                throw IllegalArgumentException("[ERROR] 구입한 로또보다 더많은 수를 입력하셨습니다.")
            }
        }
        private fun checkIntegerFormat(input: String): Int {
            try {
                return input.toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
            }
        }
        fun getValidManualLottoTicket(): SortedSet<Int> {
            var hasException = true
            var manualLotto: SortedSet<Int> = sortedSetOf()
            while (hasException) {
                try {
                    manualLotto = getManualLottoTicket().toSortedSet()
                    hasException = false
                } catch (e: Exception) {
                    println(e.message)
                }
            }
            return manualLotto
        }

        private fun getManualLottoTicket(): MutableList<Int> {
            val manualLotto = mutableListOf<Int>()
            val strings = readln().split(COMMA_DELIMITER)
            for (input in strings) {
                val validInput = checkIntegerFormat(input)
                checkRange(validInput)
                checkDuplicateNumber(manualLotto, validInput)
                manualLotto.add(validInput)
            }
            checkSize(manualLotto)
            return manualLotto
        }

        private fun checkDuplicateNumber(manualLotto: List<Int>, validInput: Int) {
            if (manualLotto.contains(validInput)) {
                throw IllegalArgumentException("[ERROR] 중복된 숫자를 입력하셨습니다.")
            }
        }

        private fun checkSize(manualLotto: List<Int>) {
            if (manualLotto.size != 6) {
                throw IllegalArgumentException("[ERROR] 6개를 입력하세요.")
            }
        }

        private fun checkRange(validInput: Int) {
            if (validInput < LottoNumber.MIN_NUMBER || validInput > LottoNumber.MAX_NUMBER) {
                throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력학세요.")
            }
        }
    }
}
