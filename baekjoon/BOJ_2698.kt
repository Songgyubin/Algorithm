package baekjoon.study.dp1
// https://mygumi.tistory.com/261
private fun main() {
    val X = 100
    val tb = List(X+1) { List(X+1) { IntArray(2) } }
    tb[1][0][0] = 1
    tb[1][0][1] = 1
    for(i in 2 .. X) {
        for(j in 0 until i) {
            tb[i][j][0] = tb[i-1][j][0] + tb[i-1][j][1]
            tb[i][j][1] = tb[i-1][j][0] + (if(j > 0) tb[i-1][j-1][1] else 0)
        }
    }

    repeat(readLine()!!.toInt()) {
        val (n, k) = readLine()!!.split(" ").map{ it.toInt() }
        println(tb[n][k].sum())
    }
}
