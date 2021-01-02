package boj.greedy

private fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val j = readLine()!!.toInt()
    var start = 1
    var end = m
    var answer = 0
    for (i in 0 until j) {
        val s = readLine()!!.toInt()
        if (s in start..end) continue
        if (s > end) {
            answer += s - end
            end = s
            start = end - (m - 1)
        } else if (s < start) {
            answer += start - s
            start = s
            end = start + (m - 1)
        }
    }
    println(answer)
}