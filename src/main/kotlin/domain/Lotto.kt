package domain

class Lotto(var numbers: Set<Int>) {
    constructor(inputNumbers: List<Int>) : this(inputNumbers.toSortedSet())
}
