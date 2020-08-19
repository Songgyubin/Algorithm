package simulation

private fun main() {
    val s = readLine()!!.toInt()

    for (i in 0 until s) {
        var answer = 0
        readLine()!!.map { it.toString().toInt() }.forEachIndexed { index, i ->
            if (index % 2 != 0) {
                answer += i
            } else {
                val tmp = i*2
                if (tmp >= 10) {
                    answer += (tmp % 10 + tmp / 10)
                } else {
                    answer += tmp
                }
            }
        }
        if (answer % 10 == 0) println("T")
        else println("F")
    }
}

