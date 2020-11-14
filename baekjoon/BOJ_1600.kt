package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess

private val goX = arrayOf(0, 0, -1, 1)
private val goY = arrayOf(1, -1, 0, 0)

private val goHorseX = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
private val goHorseY = intArrayOf(-1, 1, 2, -2, -2, 2, -1, 1)

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<Array<BooleanArray>>

private var k = 0
private var w = 0
private var h = 0
private var answer = Int.MAX_VALUE
private lateinit var st: StringTokenizer

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    k = br.readLine()!!.toInt()
    st = StringTokenizer(br.readLine())
    w = st.nextToken().toInt()
    h = st.nextToken().toInt()
    arr = Array(h) { IntArray(w) }
    vis = Array(h) { Array(w) { BooleanArray(31) } }
    for (i in 0 until h) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until w) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    bfs()
    println(-1)
}

private fun bfs() {
    val queue: Queue<Monkey> = LinkedList()
    queue.add(Monkey(0, 0, 0, k))
    while (queue.isNotEmpty()) {
        val (x, y, count, horse) = queue.poll()
        if (x < 0 || x >= h || y < 0 || y >= w) continue
        if (arr[x][y] == 1) continue

        if (x == h - 1 && y == w - 1) {
            println(count)
            exitProcess(0)
        }
        if (vis[x][y][horse]) continue
        vis[x][y][horse] = true

        for (i in 0 until 4) {
            val (curX, curY) = intArrayOf(x + goX[i], y + goY[i])
            queue.add(Monkey(curX, curY, count + 1, horse))
        }
        if (horse == 0) continue

        for (i in 0 until 8) {
            val (curX, curY) = intArrayOf(x + goHorseX[i], y + goHorseY[i])
            queue.add(Monkey(curX, curY, count + 1, horse - 1))
        }
    }

}

data class Monkey(val x: Int, val y: Int, val count: Int, val horse: Int)