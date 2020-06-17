package baekjoon.bfs

import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var arr1: Array<IntArray>
private fun main() {
    val n = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) }
    arr1 = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
            arr[i][j] = value
        }
    }
    bfs(n)
    for (i in 0 until n) {
        for (j in 0 until n) {
            print("${arr[i][j]} ")
        }
        println()
    }
}

private fun bfs(n: Int) {
    var queue: Queue<Int> = LinkedList()

    for (i in 0 until n) {
        var visited = BooleanArray(n) { false }
        queue.add(i)
        while (queue.isNotEmpty()) {
            val a = queue.poll()

            for (j in 0 until n) {
                if (arr[a][j] == 1 && !visited[j]) {
                    queue.add(j)
                    visited[j] = true
                    arr[i][j] = 1
                }
            }
        }
    }


}