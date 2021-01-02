package boj.bfs

import java.util.*
import kotlin.collections.ArrayList

private lateinit var vis: BooleanArray
private lateinit var arr: Array<ArrayList<Int>>
private val answer = ArrayList<Pair<Int, Int>>() // parent, child

private fun main() {
    val n = readLine()!!.toInt()
    vis = BooleanArray(n + 1)
    arr = Array(n + 1) { ArrayList() }

    for (i in 0 until n - 1) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        arr[a].add(b)
        arr[b].add(a)
    }

    bfs(1)
    answer.sortBy { it.second }
    answer.forEach { println(it.first) }
}

private fun bfs(s: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(s)
    vis[s] = true
    while (queue.isNotEmpty()) {
        val parent = queue.poll()
        for (i in arr[parent].indices) {
            val child = arr[parent][i]
            if (vis[child]) continue
            vis[child] = true
            answer.add(Pair(parent, child))
            queue.add(child)
        }
    }

}