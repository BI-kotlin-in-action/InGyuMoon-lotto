package domain

enum class Rank(val numberOfMatches: Int, val prizeAmount: Int) {
    FIRST_RANK(6, 100000),
    SECOND_RANK(5, 5000),
    THIRD_RANK(4, 100),
    FORTH_RANK(3, 5),
    NONE_3(2, 0),
    NONE_2(1, 0),
    NONE_1(0, 0),
}
