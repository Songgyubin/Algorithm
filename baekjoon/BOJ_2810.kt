package boj.string

private fun main() {

    readLine()!!
    var s = "*${readLine()!!}"
    s = s.replace("S", "S*").replace("LL", "LL*")
    val sb = StringBuffer(s)

    var answer = 0
    for (i in 1 until sb.length-1) {
        if (sb[i] != '*') {
            if (sb[i - 1] == '*') {
                answer++
                sb.setCharAt(i - 1, 'o')
            } else if (s[i + 1] == '*') {
                answer++
                sb.setCharAt(i + 1, 'o')
            }
        }
    }
    println(answer)
}