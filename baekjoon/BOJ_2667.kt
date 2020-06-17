package baekjoon.bfs

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<IntArray>
private lateinit var homeArr: IntArray
private val goX = intArrayOf(0, 0, -1, 1) // 동서남북
private val goY = intArrayOf(1, -1, 0, 0)

private var home = 1

private fun main() {

    val n = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        readLine()!!.map { it.toString().toInt() }.forEachIndexed { j, value ->
            arr[i][j] = value
        }
    }
    var tmpArr = ArrayList<Int>()

    bfs(n)
    homeArr.sorted().forEach {
        if (it>0) tmpArr.add(it)
    }
    println(home - 1)
    tmpArr.forEach { println(it) }
}

private fun bfs(n: Int) {
    var queue: Queue<Pair<Int, Int>> = LinkedList()
     homeArr = IntArray((n*n)+1) { 0 }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == 1) {
                home++
                queue.add(Pair(i, j))
                arr[i][j] = home
                homeArr[home]++
                while (queue.isNotEmpty()) {
                    var curX = queue.peek().first
                    var curY = queue.peek().second
                    queue.remove()
                    for (i in 0 until 4) {
                        val x = curX + goX[i]
                        val y = curY + goY[i]
                        if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == 1) {
                            queue.add(Pair(x, y))
                            arr[x][y] = home
                            homeArr[home]++
                        }
                    }

                }

            }
        }
    }

}
