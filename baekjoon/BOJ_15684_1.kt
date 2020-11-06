package boj.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var arr: Array<IntArray>
private var n = 0
private var m = 0
private var h = 0
private var answer = 0
private var isFinish = false

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    h = st.nextToken().toInt()

    arr = Array(h + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        arr[a][b] = 1
        arr[a][b + 1] = 2
    }
    for (i in 0..3) {
        answer = i
        dfs(1, 0)
        if (isFinish) break
    }
    if (isFinish) println(answer)
    else println(-1)
}

private fun dfs(x: Int, count: Int) {
    if (isFinish) return
    if (answer == count) {
        if (check()) isFinish = true
        return
    }
    for (i in x..h) {
        for (j in 1 until n) {
            if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                arr[i][j] = 1
                arr[i][j+1] = 2
                dfs(i, count + 1)
                arr[i][j] = 0
                arr[i][j + 1] = 0

            }
        }
    }
}

private fun check(): Boolean {
    for (i in 1..n) {
        var (x, y) = intArrayOf(1, i)
        for (j in 0 until h) {
            if (arr[x][y] == 1) y++
            else if (arr[x][y] == 2) y--
            x++
        }
        if (y != i) return false
    }
    return true
}