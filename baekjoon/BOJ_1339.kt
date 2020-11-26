package boj.math

import kotlin.math.pow

private var answer = 0

private val alphabet = IntArray(26)
private lateinit var arr: Array<String>
private fun main() {

    val n = readLine()!!.toInt()
    arr = Array(n) { "" }

    for (i in 0 until n) {
        val s = readLine()!!
        val lastIndex = s.lastIndex
        s.forEachIndexed { index, c -> alphabet[c - 'A'] += calc(lastIndex, index) }
    }
    var num = 9
    alphabet.sortDescending()
    alphabet.forEach {
        answer += it*num
        num--
    }
    println(answer)
}

private fun calc(lastIndex: Int, curIndex: Int): Int = 10.toDouble().pow((lastIndex - curIndex).toDouble()).toInt()

