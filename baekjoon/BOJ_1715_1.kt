package boj.priority

import java.util.*
import kotlin.system.exitProcess

private fun main() {
    val n = readLine()!!.toInt()
    if (n == 1) {
        println(0)
        exitProcess(0)
    }
    val pq = PriorityQueue<Long>()
    repeat(n) { pq.add(readLine()!!.toLong()) }
    var count = 0
    var sum = 0L
    var answer = 0L
    while (pq.isNotEmpty()) {
        count++
        sum += pq.poll()
        if (count==2){
            answer+=sum
            if (pq.isEmpty()) break
            pq.add(sum)
            count=0
            sum = 0L
        }
    }
    println(answer)

}