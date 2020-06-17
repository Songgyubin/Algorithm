package baekjoon.bfs

import java.util.*

private val go = intArrayOf(1, -1, 2)
private lateinit var queue: Queue<Int>
private lateinit var dis: IntArray

private var x = 0
private fun main() {
    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    queue = LinkedList()
    dis = IntArray(100001) { -1 }
    dis[n] = 0
    queue.add(n)
    bfs(k)

}

private fun bfs(k:Int) {

    while (dis[k]==-1) {
        var curX = queue.peek()
        queue.remove()
        for (i in go.indices) {
            if (i == 0 || i == 1) {
                x = curX + go[i]
            } else if (i == 2) {
                x = curX * go[i]
            }
            if (dis[x] == -1) {
                queue.add(x)
                dis[x] = dis[curX] + 1
            }
        }
    }
    println(dis[k])
}