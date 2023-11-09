package controller

import domain.Lotto
import domain.LottoGenerator
import domain.LottoTickets
import domain.Result
import view.InputView
import view.OutputView
import java.util.SortedSet

class LottoController {

    companion object {
        private const val LOTTO_NUMBERS_INDEX = 0
        private const val WINNING_LOTTO_TICKET_COUNT = 1
    }

    private val result = Result()

    fun start() {
        // 구입금액 입력
        val lottoPurchaseAmount = getLottoPurchaseAmount()

        // 수동으로 구입할 로또의 개수 입력
        val manualLottoAmount = getManualLottoPurchaseAmount(lottoPurchaseAmount)

        // 자동으로 로또 생성
        val autoLottoTickets = LottoGenerator.makeLottoTickets(lottoPurchaseAmount - manualLottoAmount)

        // 수동 로또 생성
        val manualLottoTickets = makeManualLotto(manualLottoAmount)

        // 자동 로또, 수동 로또 합침
        val lottoTickets = mergeTicket(autoLottoTickets, manualLottoTickets)

        // 구매한 로또 전체 출력
        OutputView.printLottoTickets(lottoTickets)

        // 당첨 생성, 로또 발표
        val winningLotto = printWinningLotto()

        // 로또 당첨금 출력
        result.updateResult(winningLotto, lottoTickets)
        val reward = result.calculateReward()
        OutputView.printLottoReward(reward)
    }

    private fun printWinningLotto(): SortedSet<Int> {
        val winningLotto = LottoGenerator.makeLottoTickets(WINNING_LOTTO_TICKET_COUNT).tickets[LOTTO_NUMBERS_INDEX].numbers
        OutputView.printWinningLottoNumber(winningLotto)
        return winningLotto
    }

    private fun makeManualLotto(manualLottoAmount: Int): LottoTickets {
        val manualLottoTickets = mutableListOf<Lotto>()
        for (i in 1..manualLottoAmount) {
            OutputView.printManualLottoMakingMessage(i)
            val manualLottoTicket = InputView.getValidManualLottoTicket()
            manualLottoTickets.add(Lotto(manualLottoTicket))
        }
        return LottoTickets(manualLottoTickets)
    }

    private fun getManualLottoPurchaseAmount(lottoPurchaseAmount: Int): Int {
        OutputView.printManualLottoPurchaseMessage()
        return InputView.getValidManualLottoAmount(lottoPurchaseAmount)
    }

    private fun getLottoPurchaseAmount(): Int {
        OutputView.printLottoPurchaseAmountMessage()
        return InputView.getValidLottoPurchaseAmount()
    }
    private fun mergeTicket(autoLottoTickets: LottoTickets, manualLottoTickets: LottoTickets): LottoTickets {
        return LottoTickets((autoLottoTickets.tickets + manualLottoTickets.tickets).toMutableList())
    }
}
