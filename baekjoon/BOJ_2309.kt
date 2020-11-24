package boj.backtracking

import kotlin.system.exitProcess

private lateinit var arr: IntArray
private lateinit var vis: BooleanArray
private lateinit var answer: ArrayList<Int>

private fun main() {
    arr = IntArray(9)
    vis = BooleanArray(9)
    answer = ArrayList()
    for (i in 0 until 9) arr[i] = readLine()!!.toInt()
    arr.sort()
    backtracking(0)
}

private fun backtracking(start: Int) {
    if (answer.size == 7) {
        if (answer.sum() == 100) {
            answer.sort()
            answer.forEach { println(it) }
            exitProcess(0)
        }
    }

    for (i in start until 9) {
        if (vis[i]) continue
        vis[i] = true
        answer.add(arr[i])
        backtracking(i)
        vis[i] = false
        answer.removeAt(answer.size - 1)
    }

}
