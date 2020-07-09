package baekjoon.string


private lateinit var stArr: Array<String>
private val visited = BooleanArray(26)
private var max = 0
fun main() {

    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    stArr = Array(n) { "" }
    if (k < 5) {
        println(0)
    } else if (k == 26) {
        println(n)
    } else {
        for (i in 0 until n) {
            val str = readLine()!!
            stArr[i] = str.substring(4, str.length - 4)
        }
        val K = k - 5
        visited['a'.toInt() - 97] = true
        visited['n'.toInt() - 97] = true
        visited['t'.toInt() - 97] = true
        visited['i'.toInt() - 97] = true
        visited['c'.toInt() - 97] = true
        dfs(0, 0, n, K)
        println(max)
    }
}

private fun dfs(start: Int, count: Int, n: Int, k: Int) {
    if (count == k) {
        var rs = 0
        for (i in 0 until n) {
            var isTrue = true
            for (j in 0 until stArr[i].length) {
                if (!visited[stArr[i][j].toInt() - 97]) {
                    isTrue = false
                    break
                }
            }
            if (isTrue) rs++
        }
        max = Math.max(max, rs)
        return
    }
    for (i in start until 26) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i, count + 1, n, k)
            visited[i] = false
        }
    }
}