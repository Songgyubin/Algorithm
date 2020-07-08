package programmers

private fun main(){

    println(solution(intArrayOf(1,5,2,6,3,7,4), arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3))).toString())
}



private fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = mutableListOf<Int>()


    // 테스트1 통과 (15.96ms, 63.1MB)
    // commands만큼 반복
    commands.forEach {
        command->
      // answer에 차례대로 값 추가
      answer.add( array.filterIndexed { index, i ->
          // i번째부터 j번째까지 slice하는것이므로
          // index가 i보다 크거나 같고 j 보다 작거나 같은 경우
            index >= (command[0]-1) && index<= (command[1]-1)
          // 정렬하고 k번째 수를 반환
        }.sorted()[command[2]-1]
      )
    }


    // 테스트 1 통과 (32.29ms, 61MB)
    /*   commands.forEach {
            command->
            // IntRange는 ( start, end )
        answer.add( array.slice(IntRange(command[0]-1,command[1]-1)).sorted()[command[2]-1]
        )
    }*/

    return answer.toIntArray()
}