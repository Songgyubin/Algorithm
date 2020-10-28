package boj.priority

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()!!.toInt()
    val arr = Array<Pair<Int, Int>>(n) { Pair(0, 0) }
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        val (s, t) = intArrayOf(st.nextToken().toInt(), st.nextToken().toInt())
        arr[i] = Pair(s, t)
    }
    arr.sortWith(compareBy({ it.first }, { it.second }))

    val pq = PriorityQueue<Int>()

    arr.forEachIndexed { i, pair ->
        val end = pair.second
        if (pq.isNotEmpty() && pq.peek() <= pair.first) pq.poll()
        pq.offer(end)
    }
    println(pq.size)

}


