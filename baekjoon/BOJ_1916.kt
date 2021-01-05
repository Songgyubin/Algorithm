package boj.dijkstra

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<ArrayList<City>>
private lateinit var dist: IntArray
private const val INF = 1000000000
private fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    arr = Array(n + 1) { ArrayList() }
    dist = IntArray(n + 1) { INF }
    for (i in 0 until m) {
        val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
        arr[a].add(City(b, c))
    }
    val (start, end) = readLine()!!.split(' ').map { it.toInt() }
    dijk(start)
    println(dist[end])
}

private fun dijk(start: Int) {

    dist[start] = 0

    val queue: Queue<City> = LinkedList()

    queue.add(City(start, 0))

    while (queue.isNotEmpty()) {
        val (curIndex, curDist) = queue.poll()

        if (dist[curIndex] < curDist) continue

        for (i in 0 until arr[curIndex].size) {

            var (nextIndex, nextDist) = arr[curIndex][i]
            nextDist += curDist

            if (nextDist < dist[nextIndex]) {
                dist[nextIndex] = nextDist
                queue.add(City(nextIndex, nextDist))
            }
        }
    }

}

private data class City(val index: Int, val dist: Int) : Comparable<City> {
    override fun compareTo(other: City): Int = this.dist - other.dist
}
