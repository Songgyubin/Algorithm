package bfs

import java.util.*

private val goX = arrayOf(0, 0, -1, 1)
private val goY = arrayOf(1, -1, 0, 0)

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>
private lateinit var current: Pair<Int, Int>

// 아기 상어
var sharkSize = 2
var sharkEatCounter = 0
var time = 0

private fun main() {
    val n = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) }
    vis = Array(n) { BooleanArray(n) }


    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
            arr[i][j] = value
            if (value == 9) {
                current = Pair(i, j)
                arr[i][j] = 0
            }
        }
    }
    check(n)

}

private fun bfs(n: Int): MutableList<Triple<Int, Int, Int>> {
    val result = mutableListOf<Triple<Int, Int, Int>>()
    vis = Array(n) { BooleanArray(n) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    var dist = 1

    queue.add(current)
    vis[current.first][current.second] = true

    while (queue.isNotEmpty()) {
        if (result.isNotEmpty()) break
        for (i in queue.indices) {
            val (x, y) = queue.poll()
            for (j in 0 until 4) {
                val curX = x + goX[j]
                val curY = y + goY[j]

                if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue
                if (vis[curX][curY] || arr[curX][curY] > sharkSize) continue

                queue.add(Pair(curX, curY))
                vis[curX][curY] = true
                if (arr[curX][curY] in 1 until sharkSize) result.add(Triple(curX, curY, dist))
            }
        }
        dist++
    }
    return result
}

private fun check(n: Int) {
    while (true) {
        val fishCanEat = bfs(n)
        if (fishCanEat.isEmpty()) break

        if (fishCanEat.size > 1) fishCanEat.sortWith(compareBy({ it.first }, { it.second }))

        time += fishCanEat[0].third
        current = Pair(fishCanEat[0].first, fishCanEat[0].second)
        arr[current.first][current.second] = 0
        sharkEatCounter++

        if (sharkSize == sharkEatCounter) {
            sharkSize++
            sharkEatCounter = 0
        }
    }
    println(time)
}
