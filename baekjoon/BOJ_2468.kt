package baekjoon.bfs

import java.util.*
import kotlin.math.max


private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private fun main() {
    val n = readLine()!!.toInt()
    var maxAns = 0
    var maxVal = 0
    arr = Array(n) { IntArray(n) }


    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
            arr[i][j] = value
        }
    }

    for (i in arr.indices) {
        maxVal = max(maxVal, arr[i].max()!!)
    }
    for (i in 0 until maxVal) {
        maxAns = max(maxAns, bfs(i, n))
    }
    println(maxAns)
}

private fun bfs(rain: Int, n: Int): Int {
    var answer = 0
    vis = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] > rain && !vis[i][j]) {
                var queue: Queue<Pair<Int, Int>> = LinkedList()
                vis[i][j] = true
                answer++
                queue.add(Pair(i, j))
                while (queue.isNotEmpty()){
                    val curX = queue.peek().first
                    val curY = queue.peek().second
                    queue.poll()
                    for (i in 0 until 4){
                        val x = curX+ goX[i]
                        val y = curY + goY[i]

                        if (x>=0 && x<n && y>=0 && y<n && !vis[x][y] && arr[x][y]>rain){
                            vis[x][y] = true
                            queue.add(Pair(x,y))
                        }
                    }
                }
            }
        }
    }
    return answer
}