package boj.bfs

import java.util.*
import kotlin.system.exitProcess

private val goX = intArrayOf(0, 0, 1, -1, 0, 0)
private val goY = intArrayOf(1, -1, 0, 0, 0, 0)
private val goZ = intArrayOf(0, 0, 0, 0, 1, -1)

private lateinit var arr: Array<Array<IntArray>>

private lateinit var queue: Queue<Triple<Int, Int, Int>>

private var answer = -1
private var isAble = false

private fun main() {
    val (m, n, h) = readLine()!!.split(' ').map { it.toInt() }

    arr = Array(h) { Array(n) { IntArray(m) } }
    queue = LinkedList()
    for (i in 0 until h) {
        for (j in 0 until n) {
            readLine()!!.split(' ').map { it.toInt() }.forEachIndexed { k, value ->
                arr[i][j][k] = value
                if (value == 1) {
                    queue.add(Triple(i, j, k))
                    isAble = true
                }
            }
        }
    }
    if (isAble) {
        bfs(m, n, h)
        for (i in 0 until h) {
            for (j in 0 until n) {
                for (k in 0 until m) {
                    if (arr[i][j][k] == 0) {
                        println(-1)
                        exitProcess(0)
                    }
                }
            }
        }
        println(answer)
    } else {
        println(-1)
    }


}

private fun bfs(m: Int, n: Int, h: Int) {

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val (z, x, y) = queue.poll()
            for (i in 0 until 6) {
                val (nz, nx, ny) = intArrayOf(z + goZ[i], x + goX[i], y + goY[i])
                if (nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                if (arr[nz][nx][ny] != 0) continue
                queue.add(Triple(nz, nx, ny))
                arr[nz][nx][ny] = 1
            }
        }
        answer++
    }
}
