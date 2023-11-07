package domain

class Result(var result: IntArray = IntArray(7)) {
    fun updateResult(winner: List<Int>, tickets: List<Lotto>): IntArray {
        /*
        tickets.forEach { ticket ->
            val matchingNumbers = winner.intersect(ticket.numbers).size
            result[matchingNumbers]++
        }
        */
        for (ticket in tickets) {
            val matchingNumbers = winner.intersect(ticket.numbers).size
            result[matchingNumbers]++
        }
        return result
    }
    fun calculateReward(): Int {
        var totalPrizeAmount = 0
        val ranks = Rank.values().reversedArray()
        for (numberOfMatches in result.indices) {
            if (numberOfMatches < 3) {
                continue
            }
            val prize = ranks.getOrNull(numberOfMatches)
            if (prize != null) {
                totalPrizeAmount += (prize.prizeAmount * result[numberOfMatches])
            }
        }
        return totalPrizeAmount
    }
}
