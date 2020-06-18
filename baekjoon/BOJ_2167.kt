package baekjoon.dp

private lateinit var arr: Array<IntArray>

private fun main() {

    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
            arr[i][j] = value
        }
    }
    val k = readLine()!!.toInt()
    for (z in 0 until k) {
        var answer = 0
        var s = readLine()!!.split(' ').map(String::toInt).map { it-1 }
        for (i in s[0]..s[2]) {
            for (j in s[1]..s[3]) {
                answer += arr[i][j]
            }
        }
        println(answer)
    }
}
