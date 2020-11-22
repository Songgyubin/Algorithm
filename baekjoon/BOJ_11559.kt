package boj.bfs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<CharArray>
private lateinit var vis: Array<BooleanArray>
private var set = HashSet<Int>()
private var isPuyo = true
private var answer = 0

private fun main() {

    arr = Array(12) { CharArray(6) }
    vis = Array(12) { BooleanArray(6) }
    for (i in 0 until 12) {
        val s = readLine()!!
        for (j in 0 until 6) {
            arr[i][j] = s[j]
        }
    }

    while (isPuyo) {
        isPuyo = false
        set = HashSet()
        bfs()

        if (isPuyo) {
            for (i in set.iterator()) {
                move(i)
            }
        }
        if (!isPuyo) break
        answer++
    }
    println(answer)
}

private fun bfs() {





    for (i in 11 downTo 0) {
        for (j in 0 until 6) {
            vis = Array(12) { BooleanArray(6) }
            val queue: Queue<Pair<Int, Int>> = LinkedList()

            if (arr[i][j] == '.' || vis[i][j]) continue

            val puyo = ArrayList<Pair<Int, Int>>()

            vis[i][j] = true
            queue.add(Pair(i, j))
            puyo.add(Pair(i, j))

            val color = arr[i][j]

            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                for (k in 0 until 4) {
                    val (curX, curY) = intArrayOf(x + goX[k], y + goY[k])
                    if (curX < 0 || curX >= 12 || curY < 0 || curY >= 6) continue
                    if (vis[curX][curY] || arr[curX][curY] == '.') continue
                    if (arr[curX][curY] != color) continue
                    queue.add(Pair(curX, curY))
                    vis[curX][curY] = true
                    puyo.add(Pair(curX, curY))
                }
            }
            if (puyo.size >= 4) {
                puyopuyo(puyo)
                isPuyo = true
            }
        }
    }
}

private fun puyopuyo(list: ArrayList<Pair<Int, Int>>) {
    for (i in list.indices) {
        val (x, y) = list[i]
        arr[x][y] = '.'
        set.add(y)
    }
}

private fun move(y: Int) {

    for (i in 11 downTo 0) {
        if (arr[i][y] == '.') continue
        var x = i
        val color = arr[i][y]
        var isChange = false
        while (true) {
            if (x == 11) break
            if (arr[x + 1][y] != '.') break
            isChange = true
            x++
        }
        if (isChange) {
            arr[x][y] = color
            arr[i][y] = '.'
        }
    }
}