package programmers

import java.lang.Integer.max

// 각 수포자의 정해진 규칙에 의한 답
private var first = intArrayOf(1, 2, 3, 4, 5)
private val second = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
private var third = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

// 각 수포자 점수
private var score = IntArray(3)

// 리스트 활용을 위한 인덱스 변수

private fun main() {
    solution(intArrayOf(1, 2, 3, 4, 5)).forEach {
        print(it)
    }
}

private fun solution(answers: IntArray): IntArray {
    lateinit var answer: IntArray

    // 주어진 정답을 1번부터 비교
    for (i in answers.indices) {
        if (first[i % first.size] == answers[i]) {
            score[0]++
        }
        if (second[i % second.size] == answers[i]) {
            score[1]++
        }
        if (third[i % third.size] == answers[i]) {
            score[2]++
        }
    }

    // 세 명의 점수가 같을 때
    if (score[0] == score[1] && score[1] == score[2]) {
        // 어차피 3명 비교하는것이기 때문에 따로 sorting 하지 않고
        // 하드코딩으로 입력
        answer = intArrayOf(1, 2, 3)
    } else {
        var tmp = ArrayList<Int>()

        val maxScore = max(score[0], max(score[1], score[2]))
        if (maxScore == score[0]) tmp.add(1)
        if (maxScore == score[1]) tmp.add(2)
        if (maxScore == score[2]) tmp.add(3)

        answer = tmp.toIntArray()

    }

    return answer
}

