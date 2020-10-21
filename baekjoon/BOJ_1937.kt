package boj.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<IntArray>
private lateinit var dp: Array<IntArray>
private lateinit var st: StringTokenizer
private var answer = 0
private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    arr = Array(n) { IntArray(n) }
    dp = Array(n) { IntArray(n) { -1 } }

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until n) {
            val size = st.nextToken().toInt()
            arr[i][j] = size
        }
    }
    for (i in 0 until n){
        for (j in 0 until n){
            if (dp[i][j] == -1) answer = max(answer, move(n, i, j))
        }
    }

    bw.write(answer.toString())
    bw.flush()
    bw.close()

}

private fun move(n: Int, x: Int, y: Int): Int {
    if (dp[x][y] != -1) return dp[x][y]
    dp[x][y] = 1
    for (i in 0 until 4) {
        val (nextX, nextY) = intArrayOf(x + goX[i], y + goY[i])
        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue
        if (arr[x][y] <= arr[nextX][nextY]) continue
        dp[x][y] = max(dp[x][y], move(n, nextX, nextY) + 1)
    }
    return dp[x][y]
}
