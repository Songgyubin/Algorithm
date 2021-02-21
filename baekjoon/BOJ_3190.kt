package boj.simulation

import java.util.*
import kotlin.collections.HashMap

private val goX = intArrayOf(0, 1, 0, -1)
private val goY = intArrayOf(1, 0, -1, 0)
private var dir = 0

private lateinit var arr: Array<IntArray>
private lateinit var hashMap: HashMap<Int, String>

// 벽 또는 자기자신의 몸과 부딪히면 게임 끝
private fun main() {

    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) }
    // 1: 뱀 2: 사과
    for (i in 0 until k) {
        val (x, y) = readLine()!!.split(' ').map { it.toInt() - 1 }
        arr[x][y] = 2
    }
    val d = readLine()!!.toInt()
    hashMap = HashMap<Int, String>()
    for (i in 0 until d) {
        val (sec, dd) = readLine()!!.split(' ')
        hashMap[sec.toInt()] = dd
    }
    arr[0][0] = 1
    println(move(n))
}

private fun move(n: Int): Int {
    val dq: Deque<Pair<Int, Int>> = LinkedList()
    dq.add(Pair(0, 0))
    var time = 0
    while (true) {
        val (x, y) = dq.peekLast()
        val (nx, ny) = intArrayOf(x + goX[dir], y + goY[dir])
        time++
        if (!hashMap[time].isNullOrEmpty()) {
            if (hashMap[time] == "D") dir = (dir + 1) % 4
            else {
                if (dir == 0) dir = 3
                else dir -= 1
            }
        }
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) break
        if (arr[nx][ny] == 1) break

        if (arr[nx][ny] != 2) {
            val (a, b) = dq.pollFirst()
            arr[a][b] = 0
        }
        dq.addLast(Pair(nx, ny))
        arr[nx][ny] = 1
    }
    return time
}