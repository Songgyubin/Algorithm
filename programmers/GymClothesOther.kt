package programmers

// 코드가 간결

private fun main(){

    solution(7, intArrayOf(2,5), intArrayOf(3,4))
}

private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

    var answer = n
    var lostSet = lost.toSet() - reserve.toSet() // 2,5  ( - 는 중복하는거 빼줌) ex) 1,2,3 와 2,3 이 있으면 1만 나옴
    var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet // 3,4

    for (i in lostSet) {
        println(i)

        when {
            // 오른쪽 학생이 여벌 옷 가지고 있으면 remove
            i + 1 in reserveSet -> reserveSet.remove(i + 1)
            // 왼쪽 학생이 여벌 옷 가지고 있으면 remove
            i - 1 in reserveSet -> reserveSet.remove(i - 1)
            // remove할게 없으면 전체 학생 수 --
            else -> answer--
        }
    }
    return answer
}
