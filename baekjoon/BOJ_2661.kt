package boj.backtracking

import kotlin.system.exitProcess

private fun main() {
    val n = readLine()!!.toInt()
    if (n == 1) {
        println(1)
        return
    }
    backtracking("", n)

}

private fun backtracking(s: String, n: Int) {
    if (s.length == n) {
        println(s)
        exitProcess(0)
    }
    for (i in 1..3) {
        if (isGood(s + i)) {
            backtracking(s + i, n)
        }
    }
}

private fun isGood(s: String): Boolean {
    var len = s.length / 2
    for (i in 1..len) {
        if (s.substring(s.length - i) == s.substring(s.length - 2 * i, s.length - i)) {
            return false;
        }
    }
    return true
}