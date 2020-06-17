package baekjoon.bfs

import java.util.*
import kotlin.math.max

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>
private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private var maxWide = 0 // 가장 넓은 그림 넓이

private var pictuers = 0 // 그림 수

private fun main() {
    val sc = Scanner(System.`in`)
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }
    vis = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        arr[i] = readLine()!!.split(' ').map(String::toInt).toIntArray()
    }
    bfs(n, m)
    println(pictuers)
    println(maxWide)
}

private fun bfs(n: Int, m: Int) {

    for (i in 0 until n) {
        for (j in 0 until m) {

            if (arr[i][j] == 1) {
                pictuers++
                var queue: Queue<Pair<Int, Int>> = LinkedList()
                arr[i][j] = -1
                queue.add(Pair(i, j))
                var tmpWide = 0
                while (queue.isNotEmpty()) {
                    tmpWide++
                    var cur = Pair(queue.peek().first, queue.peek().second)
                    queue.remove()
                    for (i in goX.indices) {
                        val nx = cur.first + goX[i]
                        val ny = cur.second + goY[i]

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny]==1) {
                            arr[nx][ny] = -1
                            queue.add(Pair(nx, ny))
                        }
                    }
                }
                maxWide = max(maxWide, tmpWide)
            }
        }
    }

}