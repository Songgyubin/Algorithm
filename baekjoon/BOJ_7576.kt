package baekjoon.bfs

import java.util.*
import kotlin.math.max

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private var answer = 0

private lateinit var arr: Array<IntArray>
private lateinit var date: Array<IntArray>
private lateinit var queue: Queue<Pair<Int, Int>>
private fun main() {
    val (m, n) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }
    date = Array(n) { IntArray(m) { 0 } }
    queue = LinkedList()

    for (i in 0 until n) {
        readLine()!!.split(' ').forEachIndexed { j, s ->
            arr[i][j] = s.toInt()
            if (s == "1") {
                queue.add(Pair(i, j))
            }
            if (s == "0"){
                date[i][j] = -1
            }
        }
    }

    bfs(n, m)

}

private fun bfs(n: Int, m: Int) {

    while (queue.isNotEmpty()) {
        val curX = queue.peek().first
        val curY = queue.peek().second
        queue.remove()
        for (i in goX.indices) {
            val x = curX + goX[i]
            val y = curY + goY[i]
            if (x >= 0 && x < n && y >= 0 && y < m && date[x][y] < 0) {
                date[x][y] = date[curX][curY] + 1
                queue.add(Pair(x, y))
            }
        }
    }


    for (i in 0 until n){
        for (j in 0 until m){
            if (date[i][j] == -1){
                println(-1)
                return
            }
            answer = max(answer, date[i][j])
        }
    }
    println(answer)
}