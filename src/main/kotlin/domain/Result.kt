package domain

class Result(var result: IntArray = IntArray(7)) {
    fun updateResult(winner: List<Int>, ticket: MutableList<Lotto>): IntArray {
        for (i in 0 until ticket.size) {
            val matchingNumbers = winner.intersect(ticket[i].numbers).toList().size
            result[matchingNumbers]++
        }
        return result
    }
    fun calculateReward(): Int {
        var totalPrizeAmount = 0
        for (i in result.indices) {
            val numberOfMatches = i
            val prize = Rank.values().firstOrNull { it.numberOfMatches == numberOfMatches }
            if (prize != null) {
                totalPrizeAmount += (prize.prizeAmount * result[i])
            }
        }
        return totalPrizeAmount
    }
}
