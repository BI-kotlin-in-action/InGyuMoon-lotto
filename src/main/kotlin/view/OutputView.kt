package view

import domain.Lotto
import domain.LottoTickets
import java.util.SortedSet

class OutputView {
    companion object {
        private const val LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val MANUAL_LOTTO_PURCHASE_MESSAGE = "수동으로 구입할 로또의 개수를 입력해주세요."
        private const val MAKING_MANUAL_LOTTO_MESSAGE = "번째 수동 로또 번호를 입력하세요."
        private const val LOTTO_TICKETS_MESSAGE = "\n구매한 로또는 아래와 같습니다."
        private const val WINNING_LOTTO_MESSAGE = "\n당첨 로또를 발표하겠습니다.\n당첨로또 : "
        private const val REWARD_MESSAGE = "총 상금은 "
        fun printLottoPurchaseAmountMessage() {
            println(LOTTO_PURCHASE_AMOUNT_MESSAGE)
        }

        fun printManualLottoPurchaseMessage() {
            println(MANUAL_LOTTO_PURCHASE_MESSAGE)
        }
        fun printManualLottoMakingMessage(num: Int) {
            println("$num$MAKING_MANUAL_LOTTO_MESSAGE")
        }
        fun printLottoTickets(lottoTickets: LottoTickets) {
            println(LOTTO_TICKETS_MESSAGE)
            for (lottoTicket in lottoTickets.tickets) {
                println(lottoTicket.numbers)
            }
        }
        fun printWinningLottoNumber(winningNumber: Set<Int>) {
            println("$WINNING_LOTTO_MESSAGE$winningNumber")
        }
        fun printLottoReward(reward: Int) {
            println("$REWARD_MESSAGE$reward KW 입니다.")
        }
    }
}
