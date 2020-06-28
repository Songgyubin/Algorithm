package programmers

import java.util.*

private fun main() {

    println(
        solution(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 3),
                intArrayOf(0, 2, 5, 0, 1),
                intArrayOf(4, 2, 4, 4, 2),
                intArrayOf(3, 5, 1, 3, 1)
            ), intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
        )
    )
}

private fun solution(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0
    var basket = Stack<Int>()

    moves.forEach { move ->
        for (i in board.indices) {
            if (board[i][move - 1] != 0) {
                // 바구니와 다음 뽑힐 인형 비교
                // 중복된다면 pop
                if (basket.isNotEmpty() && basket.peek() == board[i][move - 1]) {
                    answer += 2
                    basket.pop()
                    // 인형이 중복되지 않는다면 push
                } else {
                    basket.push(board[i][move - 1])
                }
                // 중복 되는 line이 있으므로 
                // 인형을 뽑았다는 걸 0 으로 표시
                board[i][move - 1] = 0
                break
            }
        }
    }
    return answer
}
