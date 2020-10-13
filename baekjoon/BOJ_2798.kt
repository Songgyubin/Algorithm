package boj.bruteforce

import kotlin.math.max

private var answer = 0
private var maxScore = 0

private lateinit var card: Array<Int>
private lateinit var vis: Array<Boolean>
private fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    maxScore = m
    card = Array(n) { 0 }
    vis = Array(m) { false }
    card = readLine()!!.split(' ').map { it.toInt() }.toTypedArray()
    backTracking(0, 0, 0)
    println(answer)
}

private fun backTracking(count: Int, score: Int, start: Int) {
    if (count == 3) {
        if (score <= maxScore) answer = max(answer, score)
        return
    }
    for (i in start until card.size) {
        if (!vis[i]) {
            vis[i] = true
            backTracking(count + 1, score + card[i], i + 1)
            vis[i] = false
        }
    }
}