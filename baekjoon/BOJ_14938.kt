package boj.floydwarshall

import kotlin.math.min

private fun main() {
    val (n, m, r) = readLine()!!.split(' ').map { it.toInt() }
    val items = readLine()!!.split(' ').map { it.toInt() }

    val dist = Array(n) { Array(n) { 1000000000 } }

    for (i in 0 until n) dist[i][i] = 0

    repeat(r) {
        val (a, b, l) = readLine()!!.split(' ').map { it.toInt() - 1 }
        dist[a][b] = min(dist[a][b], l + 1)
        dist[b][a] = min(dist[b][a], l + 1)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                dist[i][j] = min(dist[i][k] + dist[k][j],dist[i][j])
            }
        }
    }
    println((0 until n).map { u ->
        (0 until n).filter { v ->
            dist[u][v] <= m
        }.map { items[it] }.sum()
    }.maxOrNull())


}