package bruteforce

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.min


private lateinit var bw: BufferedWriter
private lateinit var br: BufferedReader

private var start = 100
private lateinit var error: IntArray

private fun main() {
    bw = BufferedWriter(OutputStreamWriter(System.out))
    br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine()!!.toInt()
    val m = br.readLine()!!.toInt()
    error = IntArray(m)
    var isAnswer = true
    val strN = n.toString()

    if (n == start) {
        bw.write("0\n")
        bw.flush()
        bw.close()
        return
    }

    if (m!=0) {
        br.readLine()!!.split(' ').forEachIndexed { i, v ->
            error[i] = v.toInt()
            if (strN.contains(v)) {
                isAnswer = false
            }
        }
    }
    if (error.size==10) {
        println(abs(100-n))
        return
    }
    if (isAnswer) {
        bw.write("${min(abs(start - n), strN.length)}\n")
        bw.flush()
        bw.close()
        return
    }

        val answer = down(n)
        bw.write("${answer}\n")
        bw.flush()
        bw.close()


}

private fun down(channel: Int): Int {
    var answer = Int.MAX_VALUE

    for (i in 0 until 1000000) {
        var isAnswer = true
        for (j in error.indices) {
            if (i.toString().contains(error[j].toString())) {
                isAnswer = false
                break
            }
        }
        if (isAnswer) {
            answer = min(min(answer, abs(start - channel)), (abs(i - channel) + i.toString().length))
        }
    }
    return answer
}

