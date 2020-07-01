package programmers

private fun main(){
    println(solution(arrayOf("ㄹ","Kim")))
}
private fun solution(seoul: Array<String>): String {
    var answer = StringBuffer()

    var i = 0

    seoul.forEachIndexed { index, s ->
        if (s=="Kim") {
            i = index
        }
    }
  answer.append("김서방은")
    answer.append(i)
    answer.append("에 있다")
    return answer.toString()
}