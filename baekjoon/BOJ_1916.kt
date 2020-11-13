package boj.dijkstra

import boj.floydwarshall.INF
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<ArrayList<Node1>>
private lateinit var dist: IntArray

private val queue = PriorityQueue<Node1>()
private lateinit var st: StringTokenizer
private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    arr = Array(n + 1) { ArrayList() }
    dist = IntArray(n + 1) { INF }
    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        arr[st.nextToken().toInt()].add(Node1(st.nextToken().toInt(), st.nextToken().toInt()))
    }
    st = StringTokenizer(br.readLine())
    val (start, end) = intArrayOf(st.nextToken().toInt(), st.nextToken().toInt())
    dijkstra(start)
    println(dist[end])
}

private fun dijkstra(start: Int) {
    dist[start] = 0
    queue.add(Node1(start, 0))
    while (queue.isNotEmpty()) {
        val (curIdx, curDist) = queue.poll()
        if (dist[curIdx] < curDist) continue
        for (i in 0 until  arr[curIdx].size) {
            val (nextIdx, nextDist) = intArrayOf(arr[curIdx][i].index, curDist + arr[curIdx][i].dist)
            if (nextDist < dist[nextIdx]) {
                dist[nextIdx] = nextDist
                queue.add(Node1(nextIdx, nextDist))
            }
        }
    }
}

private data class Node1(val index: Int, val dist: Int) : Comparable<Node1> {
    override fun compareTo(other: Node1): Int = dist - other.dist
}