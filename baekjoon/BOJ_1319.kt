package boj.greedy

private fun main() {
    val n = readLine()!!.toLong()
    val arr = readLine()!!.split(' ').map { it.toLong() }

    if (n == 1L) println(arr.sorted().subList(0, 5).sum())
    else {
        val (a, b, c, d, e, f) = arr
        val first = arr.minOrNull()
        val second = listOf<Long>(d + e, d + a, d + b, d + f, e + a, a + b, b + f, f + e, c + e, c + a, c + b, c + f).minOrNull()
        val third = listOf<Long>(d + e + a, d + a + b, d + b + f, d + f + e, c + e + a, c + a + b, c + b + f, c + f + e).minOrNull()
        println(third!! * 4 + second!! * (4 * (n - 1) + 4 * (n - 2)) + first!! * (4 * (n - 1) * (n - 2) + (n - 2) * (n - 2)))
    }
}

private operator fun <E> List<E>.component6() = this[5]
