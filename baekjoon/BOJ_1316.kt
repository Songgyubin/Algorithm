package boj.implementation

private fun main() {

    val n = readLine()!!.toInt()
    var answer = 0

    loop@ for (i in 0 until n) {
        val arr = IntArray(26) { -1 }
        val s = readLine()!!
        if (s.isNullOrEmpty()) continue@loop
        for (j in s.indices) {
            val alpha = (s[j] - 'a')
            if (arr[alpha] != -1 && j - arr[alpha] > 1) continue@loop
            arr[alpha] = j
        }
        answer++
    }
    println(answer)
}