package bfs

import java.util.*
import kotlin.math.min


private val goX = arrayOf(0, 0, -1, 1)
private val goY = arrayOf(1, -1, 0, 0)
private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<Array<BooleanArray>>

private var answer = Int.MAX_VALUE
private var n = 0
private var m = 0

private fun main() {

    val s = readLine()!!.split(' ').map(String::toInt)
    n = s[0]
    m = s[1]
    arr = Array(n) { IntArray(m) }
    vis = Array(2) { Array(n) { BooleanArray(m) } }

    for (i in 0 until n) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c.toString().toInt()
        }
    }
    bfs()

    if (answer == Int.MAX_VALUE) println(-1)
    else println(answer)
}

private fun bfs() {

    var queue: Queue<Node> = LinkedList()
    queue.add(Node(0, 0, 1, 0))
    while (queue.isNotEmpty()) {
        val curX = queue.peek().x
        val curY = queue.peek().y
        val count = queue.peek().count
        val breakCount = queue.peek().breakCount
        queue.poll()
        vis[breakCount][curX][curY] = true

        if (curX == n - 1 && curY == m - 1) {
            answer = min(count, answer)
        }


        for (k in 0 until 4) {
            val x = curX + goX[k]
            val y = curY + goY[k]

            if (x >= 0 && x < n && y >= 0 && y < m) {
                if (breakCount == 1) {
                    if (!vis[1][x][y] && arr[x][y] == 0) {
                        queue.add(Node(x, y, count + 1, breakCount))
                        vis[1][x][y] = true
                    }
                } else {
                    if (arr[x][y] == 1) {
                        if (!vis[1][x][y]) {
                            queue.add(Node(x, y, count + 1, 1))
                            vis[1][x][y] = true
                        }
                    } else if (arr[x][y] == 0) {
                        if (!vis[0][x][y]) {
                            vis[0][x][y] = true
                            queue.add(Node(x, y, count + 1, 0))
                        }
                    }
                }

            }

        }


    }
}

data class Node(val x: Int, val y: Int, val count: Int, val breakCount: Int)


