package programmers

import java.util.*
private var answer = mutableListOf<Int>()
private var isFinish = false
private fun main() {
    println(solution(intArrayOf(6, 9, 5, 7, 4)))
}

private fun solution(heights: IntArray): IntArray {

    var stack = Stack<Pair<Int, Int>>()

    answer.add(0)

    while (!isFinish){
        my(heights)
    }

    return answer.toIntArray()
}

private fun my(heights: IntArray){

    for (i in (answer.size-1) downTo 0){
        if (heights[answer.size] < heights[i]){
            answer.add(i+1)
            break
        }
        else if ( heights[answer.size]>= heights[i] && i==0){
            answer.add(0)
            break
        }
    }
    if (answer.size == heights.size){
        isFinish = true
    }
}