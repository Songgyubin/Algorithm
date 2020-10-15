package dp

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var buildTime: IntArray
private lateinit var buildOrder: ArrayList<ArrayList<Int>>
private lateinit var indegree: IntArray
private lateinit var answer: IntArray

private fun main() {

    val t = readLine()!!.toInt()

    repeat(t) {
        val (n, k) = readLine()!!.split(' ').map { it.toInt() }

        answer = IntArray(n)
        indegree = IntArray(n)
        buildOrder = ArrayList()

        buildTime = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

        for (i in 0 until n) {
            buildOrder.add(ArrayList())
        }

        for (i in 0 until k) {
            val s = readLine()!!.split(' ').map { it.toInt() - 1 }
            buildOrder[s[0]].add(s[1])
            indegree[s[1]]++
        }

        val w = readLine()!!.toInt()
        getBuildTime(n, w)
    }

}

private fun getBuildTime(n: Int, w: Int) {
    val queue: Queue<Int> = LinkedList()

    for (i in 0 until n) {
        answer[i] = buildTime[i]
        if (indegree[i] == 0) queue.offer(i)
    }
    while (queue.isNotEmpty()) {
        val x = queue.poll()
        for (i in buildOrder[x]) {
            answer[i] = max(answer[i], answer[x] + buildTime[i])
            indegree[i]--
            if (indegree[i] == 0) queue.offer(i)
        }
    }
    println(answer[w - 1])
}