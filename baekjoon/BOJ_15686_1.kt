package boj.bruteforce

import kotlin.math.abs
import kotlin.math.min

private lateinit var chickens: ArrayList<Pair<Int, Int>>
private lateinit var homes: ArrayList<Pair<Int, Int>>

private lateinit var chickenVis: BooleanArray
private lateinit var chickenArr: Array<Pair<Int, Int>>

private var answer = Int.MAX_VALUE

private var n = 0
private var m = 0

private fun main() {
    val s = readLine()!!.split(' ').map { it.toInt() }
    n = s[0]; m = s[1]

    chickens = ArrayList()
    homes = ArrayList()
    chickenArr = Array(m) { Pair(0, 0) }

    for (i in 0 until n) {
        readLine()!!.split(' ').map { it.toInt() }.forEachIndexed { j, value ->
            if (value==1) homes.add(Pair(i,j))
            if (value==2) chickens.add(Pair(i,j))
        }
    }

    chickenVis = BooleanArray(chickens.size)
    choiceChicken(0, 0)

    println(answer)
}

private fun choiceChicken(start: Int, count: Int) {
    if (count == m) {
        answer = min(answer, getDist())
        return
    }
    for (i in start until chickens.size) {
        if (chickenVis[i]) continue
        chickenVis[i] = true
        chickenArr[count] = chickens[i]
        choiceChicken(i + 1, count + 1)
        chickenVis[i] = false
    }
}

private fun getDist(): Int {
    var dist = 0
    homes.forEach { home -> dist += chickenArr.minOf { chicken -> abs(home.first - chicken.first) + abs(home.second - chicken.second) } }
    return dist
}