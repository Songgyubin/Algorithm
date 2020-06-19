package baekjoon.stack

import java.util.*
import kotlin.collections.ArrayList

private fun main() {
    val a = readLine()!!.toInt()
    var b = ArrayList<Int>()
    for (i in 0 until a) {
        b.add(readLine()!!.toInt())
    }
    val c = solution(b).count {
        it == "+"
    }
    val d = solution(b).count {
        it == "-"
    }
    if (c != d) {
        println("NO")
    } else {
        solution(b).forEach {
            println(it)
        }
    }

}

private fun solution(list: ArrayList<Int>): ArrayList<String> {
    var buf = ArrayList<String>()
    var stack = Stack<Int>()
    for (i in 1..list[0]) {
        buf.add("+")
        stack.push(i)
    }
    for (j in list.indices) {
        if (j>=1 && list[j]<stack.size && list[j]>list[j-1]){
            buf.clear()
            buf.add("NO")
            return buf
        }
        else if (stack.peek() == list[j]) {
            buf.add("-")
        } else if (stack.peek() < list[j]) {

                for (i in stack.peek() + 1..list[j]) {
                    buf.add("+")
                    stack.push(i)
                }
                buf.add("-")

        } else if (stack.peek() > list[j]) {

            buf.add("-")
        }
    }
    return buf
}