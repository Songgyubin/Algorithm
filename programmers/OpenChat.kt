package programmers

private fun main() {


    solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )
}

private fun solution(record: Array<String>): Array<String> {
    var answer = mutableListOf<String>()
    var hashMap: HashMap<String, String> = HashMap()

    record.forEach {
        // 입장한 유저에 한해서 탐색
        // 나갔다가 들어올 때 닉네임을 변경하더라도
        // ID값이 같기 때문에 덮어씌워짐
        if (getCommand(it) == "Enter") {
            hashMap[getUId(it)] = getNickName(it)
        }
        // Change면 닉네임이 변경되므로
        // Uid를 키 값으로 value를 변경
        else if(getCommand(it)=="Change"){
            hashMap[getUId(it)] = getNickName(it)
        }
    }
    // 들어오고 나간 순서대로 출력해줘야하므로 ArrayList 사용
    // MutableMap은 HashMap과 비슷한데 value를 변경 가능
    // value에 nickname + 들어왔습니다 or 나갔습니다
    var tmpAnswer = ArrayList<MutableMap<String, String>>()

    record.forEach() { str ->
        // 들어왔을 때
        if (getCommand(str) == "Enter") {
            tmpAnswer.add(mutableMapOf(Pair(getUId(str), "${hashMap[getUId(str)]}님이 들어왔습니다.")))
            // 나갔을 때
        } else if (getCommand(str) == "Leave") {
            tmpAnswer.add(mutableMapOf(Pair(getUId(str), "${hashMap[getUId(str)]}님이 나갔습니다.")))
        }
    }

    // tmpAnswer의 value만 출력하면 되므로 it.values
    // 출력하면 []이 붙어서 나오기 때문에 substring으로 대괄호를 없애줌

    // [[무지님이 나갔습니다.]]
    tmpAnswer.forEach {
     answer.add(it.values.toString().substring(1,it.values.toString().lastIndex))
    }

    return answer.toTypedArray()
}

// 명령어는 항상 첫단어이고 공백으로 나뉘기 때문에
// 첫번째 공백 기준으로 리턴
// "Enter u2123 muzi"
fun getCommand(s: String): String = s.substringBefore(' ')


// 아이디값은 중간에 있으므로 양쪽 공백을 기준으로
// index값을 가져와 substring
// Leave는 예외적으로 공백이 하나이므로 공백을 기준으로
// 오른쪽에 있는 값을 가져와 리턴
// "Enter u2123 muzi"
// "Leave u2123"
fun getUId(s: String): String {
    var firstIndex = s.indexOfFirst { char -> char == ' ' }
    var lastIndex = s.indexOfLast { char -> char == ' ' }

    return if(s.contains("Leave")) {
        s.substringAfter(' ')

    }else{
        s.slice(IntRange(firstIndex + 1, lastIndex-1))
    }
}

// 닉네임은 맨 마지막에 있으므로
// 마지막 공백을 기준으로 리턴
fun getNickName(s: String): String = s.substringAfterLast(' ')