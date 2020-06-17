package baekjoon.bfs

import java.util.*
import kotlin.math.max


private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<CharArray>
private lateinit var dis: Array<IntArray>
private lateinit var dis1: Array<IntArray>
private lateinit var queueFire: Queue<Pair<Int, Int>>
private lateinit var queueJihoon: Queue<Pair<Int, Int>>

private fun main() {
    val (r, c) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(r) { CharArray(c) }
    dis = Array(r) { IntArray(c) { -1} }
    dis1= Array(r) { IntArray(c) { -1 } }
    queueFire = LinkedList()
    queueJihoon = LinkedList()

    for (i in 0 until r) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c
            if (c == 'F') {
                queueFire.add(Pair(i, j))
                dis[i][j] = 0
            }
            if (c == 'J') {
                queueJihoon.add(Pair(i, j))
                dis1[i][j] = 0
            }
        }
    }
    bfs(r,c)
}

private fun bfs(r: Int, c: Int) {

    while (queueFire.isNotEmpty()) {
        val curX = queueFire.peek().first
        val curY = queueFire.peek().second
        queueFire.remove()
        for (i in goX.indices) {
            val x = curX + goX[i]
            val y = curY + goY[i]
            if (x<0 || x>=r || y <0 || y>=c) continue
            if (dis[x][y]>=0 || arr[x][y] == '#') continue
                dis[x][y] = dis[curX][curY] + 1
                queueFire.add(Pair(x, y))
        }
    }
    while (queueJihoon.isNotEmpty()){
        val curX = queueJihoon.peek().first
        val curY = queueJihoon.peek().second
        queueJihoon.remove()
        for (i in goX.indices){
            val x = curX+ goX[i]
            val y = curY + goY[i]
            if (x<0 || x>=r || y<0 || y>=c){
                println(dis1[curX][curY]+1)
                return
            }
            if (dis1[x][y] >=0 || arr[x][y] =='#') continue
            if (dis[x][y] != -1 && dis[x][y] <= dis1[curX][curY]+1) continue

                dis1[x][y] = dis1[curX][curY]+1
                queueJihoon.add(Pair(x,y))
                    }
    }
    println("IMPOSSIBLE")
}
