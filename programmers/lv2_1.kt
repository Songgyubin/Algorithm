package programmers

import java.util.*

private fun main() {

    val a = intArrayOf(93, 30, 55)
    val b = intArrayOf(1, 30, 5)
    /*val a = intArrayOf(95, 90, 99, 99, 80, 99)
    val b = intArrayOf(1, 1, 1, 1, 1, 1)*/
    solution(a, b).forEach {
        println(it)
    }
}

private fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    //프로그레스와 스피드 계산 후 인덱스 비교?
//    var answer = mutableListOf<Int>()
    var answer = IntArray(101)
//    var tmp = IntArray(progresses.size)
    val queue: Queue<Int> = LinkedList()

    progresses.forEachIndexed { index, progress ->
        queue.add(calc(progress, speeds[index]))
    }
    var tmpDay = queue.poll()
    answer[tmpDay]++

    while (queue.isNotEmpty()) {
        val day = queue.poll()
        if (tmpDay < day) {
            answer[day]++
            tmpDay = day
        } else if (tmpDay >= day) {
            answer[tmpDay]++
        }

    }

    return answer.filter { it != 0 }.toIntArray()
}

private fun calc(progress: Int, speed: Int): Int {
    var ans = 0
    var tmpProgress = progress
    while (tmpProgress < 100) {
        ans++
        tmpProgress += speed
    }
    return ans
}