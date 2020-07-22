package programmers

import java.util.*

private lateinit var queue: Queue<Int>
private fun main() {

}

private fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    var tmpWeight = 0

    truck_weights.forEach {
        queue.offer(it)
    }


    // if truck_weights.size == 0 break
    while (true) {
        if (tmpWeight <= weight) {
            tmpWeight += queue.poll()
        } else if (tmpWeight > weight) {
            answer += bridge_length
            tmpWeight = queue.poll()

        }

    }



    return answer
}