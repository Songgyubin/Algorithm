package boj.bfs

import java.util.*

private fun main() {

    val (f, s, g, u, d) = readLine()!!.split(' ').map { it.toInt() }
    //s 출발 g 도착
    // 총 f
    val dist = IntArray(f + 1) { -1 }
    dist[s] = 0

    val queue: Queue<Int> = LinkedList()

    queue.add(s)
    while (queue.isNotEmpty()) {
        val floor = queue.poll()
        if (floor + u <= f && dist[floor + u] == -1) {
            dist[floor + u] = dist[floor] + 1
            queue.add(floor + u)
        }
        if (floor - d > 0 && dist[floor - d] == -1) {
            dist[floor - d] = dist[floor] + 1
            queue.add(floor - d)
        }

    }
    if (dist[g] == -1) println("use the stairs")
    else println(dist[g])

}