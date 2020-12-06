package programmers

import java.util.*

private fun main() {
    val bridge_length = 2
    val weight = 10
    val truck_weights = intArrayOf(7, 4, 5, 6)

    println(solution(bridge_length, weight, truck_weights))
}

private fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    var tmpWeight = 0
    val queue: Queue<Int> = LinkedList()
    truck_weights.forEach {
        while (true) {
            if (queue.isEmpty()) {
                queue.add(it)
                tmpWeight += it
                answer++
                break
            } else if (queue.size == bridge_length) {
                tmpWeight -= queue.poll()
            } else {
                if (tmpWeight + it > weight) {
                    answer++
                    queue.add(0)
                } else {
                    queue.add(it)
                    tmpWeight += it
                    answer++
                    break
                }
            }
        }
    }
    return answer + bridge_length
}