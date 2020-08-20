package bfs

import java.util.*
import kotlin.math.pow


private lateinit var isPrime: BooleanArray
private lateinit var vis: IntArray

private fun main() {
    val n = readLine()!!.toInt()
    isPrime = BooleanArray(10000) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2 until 10000) {
        if (!isPrime[i]) continue
        for (j in i + i until 10000 step i) {
            isPrime[j] = false
        }
    }

    for (i in 0 until n) {
        val (start, end) = readLine()!!.split(' ').map(String::toInt)
        if (start == end) {
            println(0)
            continue
        }

        vis = IntArray(10000)

        var ans = bfs(start, end)
        if (ans == -1) println("impossible")
        else println(ans)
    }

}

private fun bfs(start: Int, end: Int): Int {
    var queue: Queue<Int> = LinkedList()

    vis[start] = 1
    queue.add(start)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        val first = cur - (cur / 1000 * 1000)
        val second = cur - ((cur % 1000) - (cur % 100))
        val third = cur - ((cur % 100) - (cur % 10))
        val fourth = cur - (cur % 10)

        val arr = intArrayOf(first, second, third, fourth)

        for (i in arr.indices) {
            var next = 0

            for (j in 0 until 10) {
                next = arr[i] + (j * (10.toDouble().pow((3 - i).toDouble())).toInt())

                if (next in 1001 until 10000 && isPrime[next]) {

                    if (vis[next] == 0) {
                        vis[next] = vis[cur] + 1
                        if (next == end) {
                            return vis[next] - 1
                        }
                        queue.add(next)

                    }

                }

            }
        }
    }
    return -1
}

