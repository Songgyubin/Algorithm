package programmers

private fun main() {


}

private fun solution(record: Array<String>): Array<String> {
    val names = mutableMapOf<String, String>()
    for (r in record) {
        val s = r.split(" ")

        if (s[0] == "Enter" || s[0] == "Change") {
            names[s[1]] = s[2]
        }
    }

    val answer = mutableListOf<String>()
    for (r in record) {
        val s = r.split(" ")

        if (s[0] == "Enter") {
            answer.add("${names[s[1]]}님이 들어왔습니다.")
        } else if (s[0] == "Leave") {
            answer.add("${names[s[1]]}님이 나갔습니다.")
        }
    }
    return answer.toTypedArray();
}
