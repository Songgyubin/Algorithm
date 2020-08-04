package programmers

private fun main() {
    solution(intArrayOf(6,9,5,7,4))
}

private fun solution(heights: IntArray): IntArray {
    var answer = intArrayOf()
    var stack: List<Int> = listOf()
    for ((i, h) in heights.withIndex()) {

        stack = stack.dropLastWhile { t ->
            println(t)
            heights[t] <= h
        }
        answer += (stack.lastOrNull() ?: -1) + 1
        stack += i
    }
    return answer
}