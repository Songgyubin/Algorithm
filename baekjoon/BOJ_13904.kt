package boj.priority

import java.util.*

private fun main() {
    val n = readLine()!!.toInt()
    val pq = PriorityQueue<Subject>()
    for (i in 0 until n) {
        val (dDay, score) = readLine()!!.split(' ').map { it.toInt() }
        pq.add(Subject(dDay, score))
    }
    val arr = IntArray(pq.maxOf { it.dDay + 1 }) { 0 }
    while (pq.isNotEmpty()) {
        val (dDay, score) = pq.poll()
        for (i in dDay downTo 1) {
            if (arr[i] == 0) {
                arr[i] = score
                break
            }
        }
    }
    println(arr.sum())
}

data class Subject(val dDay: Int, val score: Int) : Comparable<Subject> {
    override fun compareTo(other: Subject): Int {
        if (this.score < other.score) return 1
        else if (this.score == other.score) {
            if (this.dDay > other.dDay) return 1
        }
        return -1
    }

}