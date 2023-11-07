package controller

import domain.Lotto
import domain.LottoGenerator
import domain.Result
import view.InputView
import view.OutputView

class LottoController {

    companion object {
        private const val LOTTO_NUMBERS_INDEX = 0
        private const val WINNING_LOTTO_TICKET_COUNT = 1
    }

    private val output = OutputView()
    private val input = InputView()
    private val generator = LottoGenerator()
    private val result = Result()

    fun start() {
        // 구입금액 입력
        val lottoPurchaseAmount = getLottoPurchaseAmount()

        // 수동으로 구입할 로또의 개수 입력
        val manualLottoAmount = getManualLottoPurchaseAmount()

        // 자동으로 로또 생성
        val lottoTickets = generator.makeLottoTickets(lottoPurchaseAmount - manualLottoAmount)

        // 수동 로또 추가
        addManualLotto(manualLottoAmount, lottoTickets)

        // 구매한 로또 전체 출력
        output.printLottoTickets(lottoTickets)

        // 당첨 생성, 로또 발표
        val winningLotto = printWinningLotto()

        // 로또 당첨금 출력
        result.updateResult(winningLotto, lottoTickets)
        val reward = result.calculateReward()
        output.printLottoReward(reward)
    }

    private fun printWinningLotto(): List<Int> {
        val winningLotto = generator.makeLottoTickets(WINNING_LOTTO_TICKET_COUNT)[LOTTO_NUMBERS_INDEX].numbers
        output.printWinningLottoNumber(winningLotto)
        return winningLotto
    }

    private fun addManualLotto(manualLottoAmount: Int, lottoTickets: MutableList<Lotto>) {
        for (i in 1..manualLottoAmount) {
            output.printManualLottoMakingMessage(i)
            val manualLottoTicket = input.getManualLottoTicket()
            lottoTickets.add(Lotto(manualLottoTicket))
        }
    }

    private fun getManualLottoPurchaseAmount(): Int {
        output.printManualLottoPurchaseMessage()
        val manualLottoAmount = input.getManualLottoAmount()
        return manualLottoAmount
    }

    private fun getLottoPurchaseAmount(): Int {
        output.printLottoPurchaseAmountMessage()
        val lottoPurchaseAmount = input.getLottoPurchaseAmount()
        return lottoPurchaseAmount
    }
}
