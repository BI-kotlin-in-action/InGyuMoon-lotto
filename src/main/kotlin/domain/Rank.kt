package domain

enum class Rank(val numberOfMatches: Int, val prizeAmount: Int) {
    FIRST_RANK(6, 100000),
    SECOND_RANK(5, 5000),
    THIRD_RANK(4, 100),
    FORTH_RANK(3, 5),
    NONE(0, 0),
    ;
    companion object {
        fun getRank(numberOfMatches: Int): Rank {
            return when (numberOfMatches) {
                FIRST_RANK.numberOfMatches -> FIRST_RANK
                SECOND_RANK.numberOfMatches -> SECOND_RANK
                THIRD_RANK.numberOfMatches -> THIRD_RANK
                FORTH_RANK.numberOfMatches -> FORTH_RANK
                else -> NONE
            }
        }
    }
}
