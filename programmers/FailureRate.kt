package programmers


private fun main() {

    println(solution(5, intArrayOf(4,4,4)).size)
}

private data class Stage(var level: Int, var pass: Int, var fail: Int) {

    val failRate: Float

       // 실패율이 0일때
        get() = if (fail + pass == 0) 0.0f

        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        // 도달한 수 플레이어 수 = 성공해서 뛰어넘은 플레이어 + 도달했으나 클리어 하지 못한 플레이어
        else (fail.toFloat()) / (pass + fail)
}
private fun solution(N: Int, stages: IntArray): IntArray {
    var stageInfo = Array(N) { Stage(it + 1, 0, 0) }

    for (level in stages) {
        for (i in 0 until(level - 1)) {
            stageInfo[i].pass++
        }
        if (level != N + 1) stageInfo[level - 1].fail++
    }
    stageInfo.sortByDescending { it.failRate }
    return stageInfo.map { it.level }.toIntArray()
}

