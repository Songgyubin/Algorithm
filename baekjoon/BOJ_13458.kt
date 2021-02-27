package boj

private fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(' ').map { it.toInt() }
    var answer = 0L
    val (b, c) = readLine()!!.split(' ').map { it.toInt() }
    for (i in 0 until n) {
        var aa = arr[i]
        // 총감독관은 무조건 1명만 있어야하므로
        // 1명 세고 시작
            aa -= b
            answer++

        // 부감독관 계산
        if (aa <= 0) continue
        if (aa >= c) {
            answer += aa / c
            aa %= c
        }
        // c가 2인데 남은 인원수가 1 같은 경우
        // 0 이면 감독할 필요없으므로 패스
        if (aa > 0) answer++
    }
    println(answer)
}