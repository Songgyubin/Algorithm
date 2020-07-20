package programmers

import java.util.*

private fun main() {
//"aabbaccc"	7
//"ababcdcdababcdcd"	9
//"abcabcdede"	8
//"abcabcabcabcdededededede"	14
//"xababcdcdababcdcd"

    println(solution("aabbaccc"))

//    println(solution("abcabcabcabcdededededede")) // 14

}

data class Word(
    val word : String,
    var count : Int = 1
)
private fun solution(s: String): Int {
    //"aabbaccc"	7
    var answer = Int.MAX_VALUE
    for(space in 1..s.length) {
        val compressedWordList = LinkedList<Word>()
        var startIndex = 0
        var endIndex = 0
        while(endIndex != s.length) {
            endIndex = (startIndex + space).let {
                if(it > s.length) s.length
                else it
            }
            val currentWord = s.substring(startIndex, endIndex)

            // 문자열 달라질 때
            if(compressedWordList.isEmpty() || compressedWordList.peekLast().word != currentWord) compressedWordList.add(Word(currentWord))
            // 중복 체크 count++
            else compressedWordList.peekLast().count++
            // 다음 인덱스 검사
            startIndex = endIndex
        }

        // fold : 초기값 0
        // 누산기 개념
        val length = compressedWordList.fold(0) {
                acc, word ->
            // if word.count 의 초기값은 1이므로 1이면 중복이 없다는 뜻
            // else 문자열 길이 비교이므로 toString 후 length
            acc + word.word.length + if(word.count == 1) 0 else {
                word.count.toString().length
            }
        }
        println("answer: $answer")
        println("length: $length")

        // 최소값 length중 최솟값 구하기 위해
       if(length < answer) {

            answer = length
        }
    }
    return answer
}
