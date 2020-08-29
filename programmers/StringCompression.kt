package string

private fun main() {
    val s = readLine()!!
    var answer = s.length
    for (i in 1 until s.length) {
        var j = 0
        var com = String()
        var sub = String()
        while (j + i <= s.length) {
            sub = s.substring(j, j + i)
            var n = 1
            j += i
            while (j + i <= s.length) {
                if (s.substring(j, j + i) != sub) {
                    break
                }
                j += i
                n++
            }
            com += if (n != 1) "(${n})$sub" else sub
        }
        com += s.substring(j)
        answer = Math.min(answer, com.length)
    }

    println(answer)

}