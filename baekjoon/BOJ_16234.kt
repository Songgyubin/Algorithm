package boj.bfs

import java.util.*
import kotlin.collections.ArrayList

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>

private var answer = 0
private var n = 0
private var l = 0
private var r = 0
private var flag = true
private fun main() {
    val s = readLine()!!.split(' ').map { it.toInt() }
    n = s[0]; l = s[1]; r = s[2]

    arr = Array(n) { IntArray(n) }
    vis = Array(n) { BooleanArray(n) }

    for (i in 0 until n) arr[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    while (true) {
        bfs()
        if (!flag) break
        answer++
    }

    println(answer)
}

private fun bfs() {
    flag = false
    vis = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (vis[i][j]) continue
            var total = arr[i][j]
            val moves = ArrayList<Pair<Int, Int>>()
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(Pair(i, j))
            moves.add(Pair(i, j))
            vis[i][j] = true
            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()

                for (k in 0 until 4) {
                    val (curX, curY) = intArrayOf(x + goX[k], y + goY[k])
                    if (curX < 0 || curX >= n || curY < 0 || curY >= n || vis[curX][curY]) continue
                    if (!check(arr[x][y], arr[curX][curY])) continue
                    queue.add(Pair(curX, curY))
                    vis[curX][curY] = true
                    total += arr[curX][curY]
                    moves.add(Pair(curX, curY))
                }
            }
            if (moves.size > 1) {
                move(moves, total)
            }
        }
    }
}

private fun move(moves: ArrayList<Pair<Int, Int>>, total: Int) {
    moves.forEach {
        arr[it.first][it.second] = total / moves.size
    }
    flag = true
}

private fun check(a: Int, b: Int) = kotlin.math.abs(a - b) in l..r

