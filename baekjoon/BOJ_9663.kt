package backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

private val arr = IntArray(15) { 0 }
private var answer = 0

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    backTracking(1, N)
    println(answer)

}

private fun backTracking(curRow: Int, N: Int) {

    fun checkBeforeQueens(targetRow: Int, targetCol: Int): Boolean {
        if (targetRow == 1) return true

        if (arr[targetCol] != 0) {
            return false
        }

        for (col in 1..N) {
            if (col == targetCol) continue

            if (abs(arr[col] - targetRow) == abs(col - targetCol) && arr[col] != 0) {
                return false
            }
        }
        return true
    }

    if (curRow > N) {
        answer++
        return
    }

    for (colIndex in 1..N) {
        if (checkBeforeQueens(curRow, colIndex)) {
            arr[colIndex] = curRow
            backTracking(curRow + 1, N)
            arr[colIndex] = 0
        }
    }
}

