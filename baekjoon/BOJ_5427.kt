package boj.bfs

import java.util.*
import kotlin.math.min

private val goX = intArrayOf(1, -1, 0, 0)
private val goY = intArrayOf(0, 0, 1, -1)

private lateinit var arr: Array<IntArray>
private lateinit var fireVis: Array<BooleanArray>
private lateinit var sangVis: Array<BooleanArray>

private lateinit var fire: Queue<Node>
private lateinit var sang: Queue<Node>


private var answer = Int.MAX_VALUE
private fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        answer = Int.MAX_VALUE
        fire = LinkedList()
        sang = LinkedList()
        val (w, h) = readLine()!!.split(' ').map { it.toInt() }
        arr = Array(h) { IntArray(w) }
        fireVis = Array(h) { BooleanArray(w) }
        sangVis = Array(h) { BooleanArray(w) }
        for (i in 0 until h) {
            val s = readLine()!!
            for (j in 0 until w) {
                when (s[j]) {
                    '#' -> arr[i][j] = -2 // 벽
                    '.' -> arr[i][j] = 0 // 빈 칸
                    '@' -> {
                        arr[i][j] = 0
                        sang.add(Node(i, j, 0))
                    }
                    '*' -> {
                        arr[i][j] = -1 // 불 시작
                        fire.add(Node(i, j, 0))
                    }
                }
            }
        }
        bfs(h, w)
        if (answer == Int.MAX_VALUE) println("IMPOSSIBLE")
        else println(answer)

    }
}

private fun bfs(h: Int, w: Int) {
    while (fire.isNotEmpty()) {
        val (x, y, time) = fire.poll()
        fireVis[x][y] = true
        for (i in 0 until 4) {
            val (nextX, nextY, nextTime) = intArrayOf(x + goX[i], y + goY[i], time + 1)
            if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue
            if (arr[nextX][nextY] == -2 || fireVis[nextX][nextY]) continue
            arr[nextX][nextY] = nextTime
            fireVis[nextX][nextY] = true
            fire.add(Node(nextX, nextY, nextTime))
        }
    }
    while (sang.isNotEmpty()) {
        val (x, y, time) = sang.poll()
        sangVis[x][y] = true
        for (i in 0 until 4) {

            val (nextX, nextY, nextTime) = intArrayOf(x + goX[i], y + goY[i], time + 1)
            if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) {
                answer = min(answer, nextTime)
                return
            }
            if (arr[nextX][nextY] == -2 || sangVis[nextX][nextY]) continue
            if (arr[nextX][nextY] > nextTime || arr[nextX][nextY]==0) {
                sangVis[nextX][nextY] = true
                sang.add(Node(nextX, nextY, nextTime))
            }
        }
    }

}

private data class Node(val x: Int, val y: Int, val time: Int)