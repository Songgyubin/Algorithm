package math

import java.util.*

private fun main() {

    val (k, n) = readLine()!!.split(' ').map(String::toInt)
    val arr = LongArray(k)
    val queue = PriorityQueue<Long>()

    readLine()!!.split(' ').map(String::toLong).forEachIndexed { index, value ->
        arr[index] = value
        queue.add(value)
    }

    var head = 0L
    for (i in 0 until n){
        head = queue.poll()
        for (j in 0 until k){
            queue.add(head * arr[j])

            if (head % arr[j]==0L){
                break
            }

        }

    }
    println(head)
}

