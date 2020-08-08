package bfs

import java.util.*

private var arr = IntArray(100001) { -1 }
private val go = intArrayOf(1, -1, 2)

private fun main() {

    val (n, k) = readLine()!!.split(' ').map(String::toInt)
    bfs(n, k)

}

private fun bfs(n: Int, k: Int) {

    val queue: Queue<Int> = LinkedList()
    queue.add(n)
    arr[n] = 0
    while (queue.isNotEmpty()) {
        val x = queue.poll()

        for (i in 0 until 3) {

            val curX = if (i == 2) x * go[i]
            else x + go[i]
            if (curX >= 0 && curX < arr.size && arr[curX] == -1) {
                queue.add(curX)
                arr[curX] = arr[x] + 1
            }
            if (curX == k) {
                println(arr[curX])
                return
            }
        }


    }

}