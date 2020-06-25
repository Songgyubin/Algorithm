package baekjoon.study.simulation

private fun main() {
    var (a, b, n) = readLine()!!.split(' ').map(String::toInt).sorted()

    var answer = 1

    if (a == b || a > n || b > n) {
        println("-1")
        return
    }


    while (true) {

        if (a % 2 != 0 && b - a == 1) break

        a = (a + 1) / 2
        b = (b + 1) / 2

        answer++
    }
    println(answer)

}