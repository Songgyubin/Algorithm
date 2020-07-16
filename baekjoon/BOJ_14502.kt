package bruteforce

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<IntArray>
private lateinit var copyed: Array<IntArray>
private lateinit var virus: ArrayList<Pair<Int, Int>>
private lateinit var vis: Array<BooleanArray>
private lateinit var vis1: Array<BooleanArray>

private var answer = 0
private fun main() {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }
    copyed = Array(n) { IntArray(m) }
    virus = ArrayList()
    vis1 = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, v ->
            arr[i][j] = v
            if (v == 2) virus.add(Pair(i, j))
        }
    }


    setWall(n, m, 0, 0)
    println(answer)

}

// 벽
private fun setWall(n: Int, m: Int, count: Int, start: Int) {
    if (count == 3) {
        copyMap(n, m)
        bfs(n, m, virus)
        answer = max(answer, getAnswer())
        return
    }
    for (i in start until n * m) {
        var curX = i / m
        var curY = i % m

        if (arr[curX][curY] == 0) {
            arr[curX][curY] = 1
            setWall(n, m, count + 1, i + 1)
            arr[curX][curY] = 0
        }
    }
}

private fun copyMap(n: Int, m: Int) {
    for (i in 0 until n) {
        for (j in 0 until m) {
            copyed[i][j] = arr[i][j]
        }
    }
}

// bfs 로 바꾸기
private fun dfs(n: Int, m: Int, x: Int, y: Int) {
    for (i in 0 until 4) {
        val curX = x + goX[i]
        val curY = y + goY[i]

        if (curX >= 0 && curX < n && curY >= 0 && curY < m) {
            if (copyed[curX][curY] == 0) {
                copyed[curX][curY] = 2
                dfs(n, m, curX, curY)
            }
        }
    }
}

//  영역
private fun bfs(n: Int, m: Int, virus: ArrayList<Pair<Int, Int>>) {

    var queue: Queue<Pair<Int, Int>> = LinkedList()
    virus.forEach { queue.add(Pair(it.first, it.second)) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (copyed[i][j] == 0) {

                while (queue.isNotEmpty()) {
                    val x = queue.peek().first
                    val y = queue.peek().second
                    queue.poll()

                    for (i in 0 until 4) {
                        val curX = x + goX[i]
                        val curY = y + goY[i]
                        if (curX >= 0 && curX < n && curY >= 0 && curY < m && copyed[curX][curY] == 0) {
                            queue.add(Pair(curX, curY))
                            copyed[curX][curY] = 2
                        }
                    }
                }
            }
        }
    }
}

private fun getAnswer(): Int {
    var ans = 0

    copyed.forEach {
//        it.forEach { v-> println(v) }
        ans += it.count { area -> area == 0 }
    }
    return ans
}