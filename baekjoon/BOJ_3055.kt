package bfs

import java.util.*

private val goX = arrayOf(0, 0, -1, 1)
private val goY = arrayOf(1, -1, 0, 0)
private lateinit var arr: Array<CharArray>
private lateinit var water: Array<Array<Int>>
private lateinit var dist: Array<Array<Int>>

private fun main() {

    val (r, c) = readLine()!!.split(" ").map { it -> it.toInt() }

    arr = Array(r) { CharArray(c) }
    water = Array(r) { Array(c) { -1 } }
    dist = Array(r) { Array(c) { -1 } }

    var (startx, starty, endx, endy) = intArrayOf(0, 0, 0, 0)
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 0 until r) {
        readLine()!!.forEachIndexed { j, c ->
            when (c) {
                '*' -> {
                    queue.add(Pair(i, j))
                    water[i][j] = 0
                }
                'S' -> {
                    startx = i
                    starty = j
                }
                'D' -> {
                    endx = i
                    endy = j
                }
            }
            arr[i][j] = c
        }
    }

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val curX = x + goX[i]
            val curY = y + goY[i]
            if (curX < 0 || curX >= r || curY < 0 || curY >= c)
                continue
            if (water[curX][curY] != -1)
                continue
            if (arr[curX][curY] == 'X' || arr[curX][curY] == 'D')
                continue
            water[curX][curY] = water[x][y] + 1
            queue.add(Pair(curX, curY))
        }
    }
    queue.add(Pair(startx, starty))
    dist[startx][starty] = 0
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val curX = x + goX[i]
            val curY = y + goY[i]
            if (curX < 0 || curX >= r || curY < 0 || curY >= c)
                continue
            if (dist[curX][curY] != -1)
                continue
            if (arr[curX][curY] == 'X')
                continue
            // water의 시작점과 water보다 먼저 도착하면 안 되므로
            if (water[curX][curY] != -1 && dist[x][y] + 1 >= water[curX][curY])
                continue
            dist[curX][curY] = dist[x][y] + 1
            queue.add(Pair(curX, curY))
        }
    }
    if (dist[endx][endy] == -1)
        println("KAKTUS")
    else
        println("${dist[endx][endy]}")

}