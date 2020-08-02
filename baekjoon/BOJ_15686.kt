package bruteforce

import kotlin.math.abs
import kotlin.math.min

private const val HOME = 1
private const val CHICKEN = 2

private lateinit var arr: Array<IntArray>
private lateinit var chicken: ArrayList<Pair<Int, Int>>
private lateinit var home: ArrayList<Pair<Int, Int>>
private lateinit var visit: BooleanArray
private lateinit var comPareAnswer: Array<Pair<Int, Int>>
private var n = 0
private var m = 0
private var tmpAnswer = 0
private var answer = Int.MAX_VALUE

private fun main() {
    val s = readLine()!!.split(' ').map(String::toInt)
    n = s[0]
    m = s[1]
    chicken = ArrayList()
    home = ArrayList()
    arr = Array(n) { IntArray(n) }
//    visited = Array(13) { Visit(Pair(0, 0), false) }
    visit = BooleanArray(13)
    comPareAnswer = Array(m) { Pair(0, 0) }
    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
            arr[i][j] = value
            if (value == CHICKEN) {
                chicken.add(Pair(i, j))
            } else if (value == HOME) home.add(Pair(i, j))
        }
    }
        backtracking(0, 0, m)
    println(answer)
}

private fun backtracking(count: Int, start: Int,t:Int) {
    if (count == t) {
        tmpAnswer = 0
        home.forEach { h ->
            var tmp = Int.MAX_VALUE
            comPareAnswer.forEach { c ->
                tmp = min(tmp, (abs(h.first - c.first) + abs(h.second - c.second)))
            }
            tmpAnswer += tmp
        }
        answer = min(tmpAnswer, answer)
        return
    }

    for (i in start until chicken.size) {
        if (!visit[i]) {
            visit[i] = true
            comPareAnswer[count] = chicken[i]
            backtracking(count + 1, i, t)
            visit[i] = false
        }
    }


}