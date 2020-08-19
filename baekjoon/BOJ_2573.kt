package bfs

import java.util.*

private val goX = arrayOf(0, 0, -1, 1)
private val goY = arrayOf(1, -1, 0, 0)
private var n = 0
private var m = 0
private var answer = -1
private var sep = 0


private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>
private fun main() {

    val s = readLine()!!.split(' ').map(String::toInt)
    n = s[0]
    m = s[1]

    arr = Array(n) { IntArray(m) }


    for (i in 0 until n) {
        val r = readLine()!!.split(' ').map(String::toInt).toIntArray()
        arr[i] = r
    }
    while (true) {
        answer++
        if (check()) {
            println(0)
            return
        }
        countSep()
        if (sep >= 2) {
            println(answer)
            return
        }
        melt()

    }


}

private fun melt() {
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
                            vis[i][j] = true
                        }
                    }
                }
            }
        }
    }

}

private fun countSep() {
    vis = Array(n) { BooleanArray(m) }
    sep = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] != 0 && !vis[i][j]) {
                val queue: Queue<Pair<Int, Int>> = LinkedList()
                queue.add(Pair(i, j))

                sep++
                while (queue.isNotEmpty()) {
                    val (x, y) = queue.poll()
                    vis[x][y] = true
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

private fun check(): Boolean {
    var count = 0
    for (i in 0 until n) {
        count += arr[i].count {
            it != 0
        }
    }
    return count == 0
}