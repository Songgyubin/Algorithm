package boj.priorityqueue

import java.util.*


private fun main() {
    //가장싼것 제외
    val n = readLine()!!.toInt()
    // 비싼 걸 무료로 구입하는게 제일 좋음
    val pq = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o2 - o1 })

    var count = 0
    var answer = 0
    for (i in 0 until n) pq.add(readLine()!!.toInt())
    while (pq.isNotEmpty()) {
        count++
        // 내림차순 정렬 후 3의 배수번째 물건만 무료
        if (count % 3 == 0) pq.poll()
        else answer += pq.poll()
    }
    println(answer)
}