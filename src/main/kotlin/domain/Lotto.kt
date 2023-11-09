package domain

class Lotto(var numbers: Set<Int> = emptySet()) {
    constructor(inputNumbers: List<Int>) : this() {
        numbers = inputNumbers.toSortedSet()
    }
}
