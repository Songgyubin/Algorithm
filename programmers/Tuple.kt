package programmers


private fun main() {
    solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
}

private fun solution(s: String): IntArray {

    // size가 1인것의 값은 무조건 첫번째 값
    // 각 원소의 중복은 없으므로
    // 오름차순으로 정렬하여
    // 추가되는 순서대로 튜플 찾기기
    return s.substring(2 until s.length-2)
        .split("},{")
        .asSequence() // 하나씩 물 흐르듯이 계산 -> 안 해준다면 임시 변수가 내부적으로 생성되어 비효율 // 없어도 실행되긴 함
        .map { it.split(",").map { num -> num.toInt() } }
        .toList()  // 문자열 int형 List로 변환
        .sortedBy { it.size }  // 오름차순 정렬
        .fold(setOf<Int>()) // set 형 ( 중복 허용 x ) -> 순서대로 넣기 위함
                            // fold: 초기값 설정(setOf<Int>)
                            // 왼쪽부터 오른쪽까지 현재의 계산값에 각각을 적용
                            // ex) sum = listOf(1,2,3,4,5).fold(0){total, next -> total +next }
        { acc, list ->      // print(sum) => 15

            acc.union(list)// 순차적으로 collection 합침 ( set이므로 중복된것 제외하며 추가되는 것들만 순차적으로 병합 )
        }
        .toIntArray()

}
