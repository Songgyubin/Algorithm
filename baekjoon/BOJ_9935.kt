package baekjoon.string

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() {

    //FRULA
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val bomb = br.readLine()
    val sb = StringBuffer()
    val st = Stack<Char>()

    for (i in s.length - 1 downTo 0) {
        st.push(s[i])
        if (st.size >= bomb.length && st.peek() == bomb[0]) {
            if (bomb.length == 1) {
                st.pop()
            }
            for (j in 1 until bomb.length) {
                if (st.size - 1 - j < 0) {
                    break
                }
                if (st[st.size - 1 - j] != bomb[j]) {
                    break
                }
                if (j == bomb.length - 1) {
                    for (k in bomb.indices) {
                        st.pop()
                    }
                }
            }
        }
    }
    val size = st.size
    if (size == 0) {
        println("FRULA")
    } else {
        for (i in 0 until size) {
            sb.append(st.pop())
        }
        println(sb)
    }
}
