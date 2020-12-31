package boj.string

import java.util.*

private fun main() {
    val s = readLine()!!
    val stack = Stack<Char>()
    var isArrowStart = false

    for (i in s.indices) {
        if (s[i] == '<') {
            popStack(stack)
            print("${s[i]}")
            isArrowStart = true
        } else if (s[i] == '>') {
            print("${s[i]}")
            isArrowStart = false
        } else if (s[i] == ' ') {
            popStack(stack)
            print("${s[i]}")
        } else {
            if (isArrowStart) {
                print("${s[i]}")
            } else {
                stack.push(s[i])
            }
        }
    }
    popStack(stack)
}

private fun popStack(stack: Stack<Char>) {
    while (stack.isNotEmpty()) {
        print("${stack.pop()}")
    }
}