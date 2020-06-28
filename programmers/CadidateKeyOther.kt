package programmers

private fun main() {

    println(
        solution(
            arrayOf(
                arrayOf("100", "ryan", "music", "2"),
                arrayOf("200", "apeach", "math", "2"),
                arrayOf("300", "tube", "computer", "3"),
                arrayOf("400", "con", "computer", "4"),
                arrayOf("500", "muzi", "music", "3"),
                arrayOf("600", "apeach", "music", "2")
            )
        )
    )
}

private fun solution(relation: Array<Array<String>>): Int {

    fun <T> List<T>.powerSet(): List<List<T>> {
        var r = listOf(emptyList<T>())
        tailrec fun recursive(ll: List<T>) {
            if (ll.isEmpty())
                return
            r = r.flatMap { listOf(it + ll.first(), it) }
            return recursive(ll.drop(1))
        }

        recursive(this)
        return r.toList()
    }

    val columnSize = relation.first().size
    val tupleSize = relation.size
    val powerSets = (1..columnSize).toList().powerSet().dropLast(1).sortedBy { it.size }

    val candidateKey = mutableListOf<List<Int>>()

    fun <T> List<T>.isPartOf(l: List<T>): Boolean = all { it in l }

    return powerSets.filter { set ->
        if (candidateKey.any { it.isPartOf(set) })
            false
        else {
            val keys = relation.map { tuple -> set.fold("") { acc, i -> acc + tuple[i - 1] } }

            if (keys.distinct().size == tupleSize) {
                candidateKey.add(set)
                true
            } else
                false
        }
    }.size
}