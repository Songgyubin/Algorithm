package bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {

    val n = br.readLine().toInt()

    var queue: Queue<Long> = LinkedList()

    if (n> 1022) {
        println(-1)
        return
    }
    if (n in 0 until 10){
        println(n)
        return
    }

    var cnt = -1
    for (i in 0..9L) {
        queue.add(i)
        cnt++
    }

    while (queue.isNotEmpty()) {
        val num = queue.poll()

        val digit = num % 10
        for (i in 0 until digit) {
            queue.add(num * 10 + i)
            cnt++

            if (cnt == n) {
                println(num * 10 + i)
                return
            }
        }
    }
    println(-1)
}