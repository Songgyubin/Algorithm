package boj.dijkstra

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<ArrayList<Computer>> // 번호, 시간
private lateinit var times: IntArray
private const val INF = 1000000000
private var answer = 1

private fun main() {
    repeat(readLine()!!.toInt()) {

        val (n, d, c) = readLine()!!.split(' ').map { it.toInt() }
        arr = Array(n + 1) { ArrayList() }
        times = IntArray(n + 1) { INF }
        answer = 1
        for (i in 0 until d) {
            val (a, b, s) = readLine()!!.split(' ').map { it.toInt() }
            arr[b].add(Computer(a, s))
        }

        dijkstra(c)
        println("$answer ${times.filter { it != INF }.max()}")

    }

}

private fun dijkstra(c: Int) {
    val queue = PriorityQueue<Computer>()
    times[c] = 0
    queue.add(Computer(c, 0))
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (node.time > times[node.index]) continue

        for (n in arr[node.index]) {
            if (times[n.index] > times[node.index] + n.time) {
                if (times[n.index] == INF) answer++
                times[n.index] = times[node.index] + n.time
                queue.add(Computer(n.index, times[n.index]))
            }
        }
    }

}

private data class Computer(val index: Int, val time: Int) : Comparable<Computer> {
    override fun compareTo(other: Computer): Int {
        return time - other.time
    }

}