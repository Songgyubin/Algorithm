package programmers

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

private fun main() {
    println(solution(8, 2, 6))
}

private fun solution(n: Int, a: Int, b: Int): Int {
    var answer = 1

    // 판별 하기 쉽게 작은 수와 큰 수 구별
    var tmpA = min(a,b)
    var tmpB = max(a,b)

    while(true){
        // 1번만에 만나는 경우
        // 이 경우는 둘 사이가 1차이 나고
        // 작은 수가 홀수 일때
        // 라운드 시작 시 왼쪽에 있는 수는 무조건 홀수
        if (tmpA%2 !=0 &&tmpB-tmpA == 1){
            break
        }

        // 위에 if문 조건을 만족시키기 위해
        // 결국 if문 조건은 둘 사이가 1차이나고 왼쪽 수가 홀수
        // 같은 그룹에 넣기 위해 +1하고 /2
        // ex) 1 2 면
        //  1 1 이 되어 그룹이 같아짐
        tmpA = (tmpA+1)/2
        tmpB = (tmpB+1)/2

        answer++
    }
    return answer
}
