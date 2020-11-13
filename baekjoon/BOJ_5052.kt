package boj.string

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    loop@for (i in 0 until t) {
        val n = br.readLine().toInt()
        val arr = Array(n) { br.readLine() }.sorted()
        for (j in 1 until arr.size) {
            if (arr[j - 1].length < arr[j].length) {
                if (arr[j - 1] == arr[j].substring(0, arr[j - 1].length)){
                    println("NO")
                    continue@loop
                }
            }
        }
        println("YES")
    }
}