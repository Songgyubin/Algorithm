package backtracking

import java.util.*

private fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()
    val arr = Array<Int>(n) { nextInt() }.sortedArray()

    var ans = Array<Int>(m) { -1 }
    fun dfs(depth: Int, start: Int) {
        if (depth == m) {
            println(ans.joinToString(" "))
            return
        }
        for (i in start until n) {
            ans[depth] = arr[i]
            dfs(depth + 1, i)
        }
    }

    dfs(0, 0)
}