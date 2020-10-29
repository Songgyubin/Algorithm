package boj.simulation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var arr: Array<Pair<Int, Int>>
private lateinit var dp: Array<IntArray>
private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine()!!.toInt()
    val k = br.readLine()!!.toInt()
    arr = Array(t + 1) { Pair(0, 0) }
    dp = Array(k + 1) { IntArray(t + 1) }

    for (i in 0 until k) {
        val st = StringTokenizer(br.readLine())
        arr[i] = Pair(st.nextToken().toInt(), st.nextToken().toInt())
    }

}
