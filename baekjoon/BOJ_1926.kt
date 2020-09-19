package bfs

import java.util.*
import kotlin.math.max

private val goX = arrayOf(0, 0, -1, 1)
private val goY = arrayOf(1, -1, 0, 0)

private lateinit var arr: Array<IntArray>

private fun main() {

    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        arr[i] = readLine()!!.split(' ').map(String::toInt).toIntArray()
    }
    bfs(n, m)

}

private fun bfs(n: Int, m: Int) {
    var picture = 0
    var width = 0
    var tmpWidth = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 1) {

                arr[i][j] = -1
                val queue: Queue<Pair<Int, Int>> = LinkedList()
                queue.add(Pair(i, j))

                tmpWidth = 0
                picture++
                tmpWidth++

                while (queue.isNotEmpty()) {
                    val (x, y) = queue.poll()
                    for (k in 0 until 4) {
                        val curX = x + goX[k]
                        val curY = y + goY[k]
                        if (curX in 0 until n && curY in 0 until m && arr[curX][curY] == 1){

                            queue.add(Pair(curX, curY))
                            arr[curX][curY] = -1
                            tmpWidth++
                        }
                    }
                }
                width = max(width, tmpWidth)
            }
        }
    }
    println(picture)
    println(width)
}