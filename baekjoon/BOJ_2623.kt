package boj

import java.util.*


private fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val pre = IntArray(n)

    val q: Queue<Int> = LinkedList()

    val ans = mutableListOf<Int>()

    val nexts = Array(n) { mutableListOf<Int>() }

    repeat(m) {
        val st = StringTokenizer(readLine()!!)
        val input = Array(st.nextToken()!!.toInt()) { st.nextToken()!!.toInt() - 1 }
        input.reduce { acc, i ->
            pre[i]++
            nexts[acc].add(i)
            i
        }
    }
    pre.forEachIndexed { index, i ->
        if (i == 0) q.add(index)
    }
    while (!q.isEmpty()) {
        val now = q.poll()!!
        ans.add(now + 1)
        nexts[now].forEach {
            pre[it]--
            if (pre[it] == 0) {
                q.add(it)
            }
        }
    }
    print(if (ans.size == n) ans.joinToString("\n") else 0)
}