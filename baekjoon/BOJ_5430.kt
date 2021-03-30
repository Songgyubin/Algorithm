package boj.implementation

import java.util.*

private fun main() {

    val t = readLine()!!.toInt()

    loop@ for (i in 0 until t) {
        val p = readLine()!!.toMutableList()
        val dq = ArrayDeque<Int>()
        readLine()

        readLine()!!.replace("[", "").replace("]", "").split(',').filter { !it.isNullOrEmpty() }.map { it.toInt() }
            .forEach {
                dq.add(it)
            }

        var isReverse = false
        for (i in p.indices) {

            if (p[i] == 'R') {
                isReverse = !isReverse
            } else {
                if (dq.isNullOrEmpty()) {
                    println("error")
                    continue@loop
                }
                if (isReverse) dq.pollLast()
                else dq.pollFirst()

            }
        }
        if (isReverse) println(dq.reversed().toString().replace(" ",""))
        else println(dq.toString().replace(" ",""))
    }

}