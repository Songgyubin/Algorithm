package programmers

import java.lang.Math.abs
import java.util.*


private fun main() {


    val s = readLine()!!

    var f =solution(s)
    for (i in f.indices){
        print("${f[i]} ")
    }
}

private fun solution(s:String): IntArray {
    var answer = IntArray(26){0}
    for (i in s.indices){
        answer[kotlin.math.abs(("z"[0].toInt() - s[i].toInt()) -25)]++
    }
    return answer
}