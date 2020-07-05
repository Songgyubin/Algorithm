package baekjoon.bfs

import java.util.*

private val goX = intArrayOf(1, -1, 0, 0)
private val goY = intArrayOf(0, 0, 1, -1)

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>

private var ice = 0
private var answer = -1

private fun main() {

    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
            arr[i][j] = value
        }
    }
    while (true) {
        answer++
        if (check(n, m)) {
            println(0)
            return
        }
        bfs(n, m)
        if (ice >= 2) {
            println(answer)
            return
        }
        melting(n, m)
    }
}

private fun melting(n: Int, m: Int) {
//    println("melting")
    vis = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] != 0) {
                for (k in 0 until 4) {
                    val curX = i + goX[k]
                    val curY = j + goY[k]
                    if (curX >= 0 && curX < n && curY >= 0 && curY < m && arr[curX][curY] == 0 && !vis[curX][curY]) {
                        if (arr[i][j] > 0) {
                            arr[i][j]--
                            vis[i][j]=true
                        }
                    }
                }
            }
        }
    }
}

private fun bfs(n: Int, m: Int) {
    vis = Array(n) { BooleanArray(m) }
    ice = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] != 0 && !vis[i][j]) {
                var queue: Queue<Pair<Int, Int>> = LinkedList()
                queue.add(Pair(i, j))
                ice++
                while (queue.isNotEmpty()) {
                    val x = queue.peek().first
                    val y = queue.peek().second
                    vis[x][y] = true
                    queue.poll()
                    for (k in 0 until 4) {
                        val curX = x + goX[k]
                        val curY = y + goY[k]
                        if (curX >= 0 && curX < n && curY >= 0 && curY < m && arr[curX][curY] != 0 && !vis[curX][curY]) {
                            queue.add(Pair(curX, curY))
                            vis[curX][curY] = true
                        }
                    }
                }
            }

        }
    }
}

// 다 녹으면 true
private fun check(n: Int, m: Int): Boolean {
    var count = 0
    for (i in 0 until n) {
        count += arr[i].count {
            it != 0
        }
    }
    return count == 0
}