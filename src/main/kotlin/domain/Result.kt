package domain

import java.util.SortedSet

class Result(
    private var result: HashMap<Rank, Int> = hashMapOf<Rank, Int>(
        Rank.FIRST_RANK to 0,
        Rank.SECOND_RANK to 0,
        Rank.THIRD_RANK to 0,
        Rank.FORTH_RANK to 0,
    ),
) {
    fun updateResult(winner: SortedSet<Int>, tickets: LottoTickets): HashMap<Rank, Int> {
        for (ticket in tickets.tickets) {
            val matchingNumbers = winner.intersect(ticket.numbers).size
            val rank = Rank.values().find { it.numberOfMatches == matchingNumbers }
            if (rank != null) {
                result[rank] = result.getOrDefault(rank, 0) + 1
            }
        }
        return result
    }
    fun calculateReward(): Int {
        var totalPrizeAmount = 0
        for (key in result.keys) {
            totalPrizeAmount += result[key]!! * key.prizeAmount
        }
        return totalPrizeAmount
    }
}
