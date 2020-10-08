package bfs

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: ArrayList<ArrayList<Int>>
private lateinit var dis: IntArray

private fun main() {
    val (n, m, k, x) = readLine()!!.split(' ').map(String::toInt)
    arr = ArrayList()
    dis = IntArray(n + 1) { -1 }
    for (i in 0..n) {
        arr.add(ArrayList())
    }
    for (i in 0 until m) {
        val s = readLine()!!.split(' ').map(String::toInt)
        arr[s[0]].add(s[1])
    }
    bfs(x, k)
}

private fun bfs(start: Int, k: Int) {
    val queue = LinkedList<Int>()
    queue.add(start)
    dis[start] = 0
    while (queue.isNotEmpty()) {
        val x = queue.poll()
        for (i in arr[x].indices) {
            val curX = arr[x][i]
            if (dis[curX] == -1) {
                dis[curX] = dis[x] + 1
                queue.add(curX)
            }
        }
    }
    if (dis.count { it == k } == 0) println(-1)
    else {
        dis.forEachIndexed { index, i ->
            if (i == k)
                println(index)
        }
    }

}