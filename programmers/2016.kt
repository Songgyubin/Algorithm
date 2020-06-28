package programmers

private fun main() {
    println(solution(8, 1))
}

private fun solution(a: Int, b: Int): String {
    var answer = ""
    var index = 0

    // 1월 1일(FRI) 기준으로 시작하기 때문에
    // 쉽게 보려고 FRI 부터 시작
    var dayOfWeek = arrayOf<String>("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")

    for (i in 1..a) {
        // Month 계산
        // 전 월 기준으로 날짜 더하기
        // ex) 2월은 1월이 31일이니까 index에 31을 더함
        index += if (i == 2 || i == 4 || i == 6 || i == 9 || i == 8 || i == 11) {
            31
        } else if (i == 1) {
            0
        }
        // 윤년 29일 때
        else if (i == 3) {
            29
        } else {
            30
        }
    }

    // day 계산
    index += b - 1
      //
     // 7이면 값이 0 => dayOfWeek[0] FRI
    answer = dayOfWeek[index % (dayOfWeek.size)]

    return answer
}