package boj

import kotlin.math.abs
import kotlin.math.max

private lateinit var vis: BooleanArray
private val mints = ArrayList<Pair<Int, Int>>()

private var answer = 0
private var n = 0
private var m = 0
private var h = 0
private var hx = 0
private var hy = 0

private fun main() {
    readLine()!!.split(' ').map { it.toInt() }.forEachIndexed { index, i ->
        when (index) {
            0 -> n = i
            1 -> m = i
            2 -> h = i
        }
    }

    for (i in 0 until n) {
        readLine()!!.split(' ').map { it.toInt() }.forEachIndexed { j, value ->

            if (value == 1) {
                hx = i
                hy = j
            } else if (value == 2) mints.add(Pair(i, j))
        }
    }
    vis = BooleanArray(mints.size)
    backtracking(0, IntArray(mints.size))

    println(answer)

}

private fun backtracking(count: Int, tmpArr: IntArray) {
    if (count == tmpArr.size) {
        getMint(tmpArr)
        return
    }
    for (i in tmpArr.indices) {
        if (vis[i]) continue
        vis[i] = true
        tmpArr[count] = i
        backtracking(count + 1, tmpArr)
        vis[i] = false
    }
}

private fun getMint(tmpArr: IntArray) {
    var x = hx
    var y = hy
    var hp = m
    var count = 0
    for (i in tmpArr.indices) {
        var index = tmpArr[i]
        var dist = abs(x - mints[index].first) + abs(y - mints[index].second)
        var distHome = abs(hx - mints[index].first) + abs(hy - mints[index].second)
        if (hp >= dist) {
            hp += h - dist
            count++
            if (hp >= distHome) answer = max(answer, count)
            x = mints[index].first
            y = mints[index].second
        } else return
    }
}

