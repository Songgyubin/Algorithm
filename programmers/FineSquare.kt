package programmers

import kotlin.math.max
import kotlin.math.min


private fun main() {

    println(solution(8, 12))
//    println(gcd(4,11))
}

private fun solution(w: Int, h: Int): Long {
    val lw = w.toLong()
    val lh = h.toLong()

    var answer: Long = (lw * lh)
    // 처음엔 좌표로 탐색했지만 안되서 검색
    // 대각선에 그어진 사각형 개수 구하는 공식
    // w + h - 최대공약수
    return answer - (lw + lh - gcd(lw, lh))
}

// 최대공약수
fun gcd(a: Long, b: Long): Long {
    var maximum = max(a, b)
    var minimum = min(a, b)

    // a > b
    // b가 0이 나올때까지 a를 b로 나누고
    // b를 a와 b로 나눈 나머지로 나누고 반복
    // 최종으로 나누는 값이 최대공약수( 유클리드 호제법 )
    if (minimum == 0.toLong()) {
        return max(a, b)
    } else {
        return gcd(minimum, maximum % minimum)
    }
}


