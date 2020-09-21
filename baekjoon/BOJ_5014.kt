package bfs

import java.util.*
import kotlin.system.exitProcess


private fun main() {
    val (F, S, G, U, D) = readLine()!!.split(' ').map(String::toInt)
    if (S > F) {
        println("use the stairs")
        exitProcess(0)
    }
    val dist = Array<Int>(F + 1) { -1 }
    dist[S] = 0

    val queue: Queue<Int> = LinkedList()

    queue.add(S)
    while (queue.isNotEmpty()) {
        val floor = queue.poll()

        if (floor + U <= F && dist[floor + U] == -1) {
            dist[floor + U] = dist[floor] + 1
            queue.add(floor + U)
        }
        if (floor - D > 0 && dist[floor - D] == -1) {
            dist[floor - D] = dist[floor] + 1
            queue.add(floor - D)
        }

    }
    if (dist[G] == -1) {
        println("use the stairs")
        exitProcess(0)
    } else println(dist[G])


}