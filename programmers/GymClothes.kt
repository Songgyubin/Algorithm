package programmers

// 다른 사람들 풀이 봤지만 실행속도, 메모리가 내꺼가 가장 최적

private lateinit var numberOfClothes: IntArray

private fun main() {

    println(solution(3, intArrayOf(2,3), intArrayOf(2)))

}

private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

    var answer = 0

    // size: 전체학생수, 가지고 있는 옷 개수 ( 0, 1, 2)
    // 1벌씩 가지고 있다고 초기화
    // -> 여벌 옷을 가진 학생은 하나만 도난 당했다고 가정했으므로
    // -> 여벌옷은 2개를 가진상태로 도난을 당했으면 1벌이므로 자신만 입을 수 있고
    // -> 도난을 당하지 않았으면 2벌을 가졌으므로 1벌을 줄 수 있다.
    numberOfClothes = IntArray(n) { 1 }


    // 여벌 옷 가진 학생들 옷 개수 ++ => 2
    reserve.forEach {
        numberOfClothes[it - 1]++
    }

    // 도난 당한 학생들 옷 개수 -- => 0 or 1
    lost.forEach {
        numberOfClothes[it - 1]--
    }

    // 전체 학생 수 만큼 반복
    for (i in numberOfClothes.indices) {
        // 도난 당한 학생들만 처리하면 되므로 옷이 0개인 학생들만 검사
        if (numberOfClothes[i] == 0) {

            // // 첫번째 학생은 다음 번호 학생하고만 비교
            if (i == 0) {

                // 다음 번호 학생이 여벌의 옷을 가지고 있다면
                // 즉 2벌인 경우에
                if (numberOfClothes[i + 1] == 2) {
                    // 옷을 받으므로 ++ => 1
                    numberOfClothes[i]++
                    // 옷을 빌려주므로 -- => 1
                    numberOfClothes[i + 1]--
                }
                // 마지막 학생은 이전 번호 학생하고만 비교
            } else if (i == numberOfClothes.lastIndex) {

                if (numberOfClothes[i - 1] == 2) {
                    numberOfClothes[i]++
                    numberOfClothes[i - 1]--
                }
                // 왼쪽 번호 학생부터 검사

                //  2 0 2 0 1
                //  2 1 1 0 1 4명
                //  1 1 1 1 1 5명 = result
            } else if (numberOfClothes[i - 1] == 2) {
                numberOfClothes[i]++
                numberOfClothes[i - 1]--

            } else if (numberOfClothes[i + 1] == 2) {
                numberOfClothes[i]++
                numberOfClothes[i + 1]--
            }
        }
    }

    // 여벌의 옷을 가지고 있지만 주지 못하는 경우도 있기 때문에
    // 최종적으로 1벌이나 2벌을 가지고 있는 학생들의 수 대입
    answer = numberOfClothes.count {
        it == 1 || it == 2
    }

    return answer
}