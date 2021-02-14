package boj.greedy

private lateinit var fiboArr: IntArray
private var pointIndex = 0 // n 이상인 수 중 n과 가장 가까운 인덱스

// n 이하인 수 중 n과 가장 가까운 수를 구하기 위해
private fun main() {

    val t = readLine()!!.toInt()
    val fiboMax = 47
    fiboArr = IntArray(fiboMax) // 구해봤더니 46이 입력 최대보다 많고 젤 가깝
    fiboArr[0] = 0
    fiboArr[1] = 1

    repeat(t) {
        val target = readLine()!!.toInt()
        getFibo(target)
        val answer = getAnswer(pointIndex, target).reversed()

        println(answer.joinToString(" "))
        pointIndex = 0
    }
    // 피보 구하고 가까운 것 구하고 점차 점차~~~~!~!!@!@!@!@!@!@!@

}

private fun getFibo(target: Int) {
    for (i in 2 until 47) {
        fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2]
        if (fiboArr[i] > target && pointIndex == 0) {
            pointIndex = i
        }
    }
}

private fun getAnswer(index: Int, target: Int): ArrayList<Int> {
    var sum = 0
    val answer = ArrayList<Int>()
    for (i in index downTo 1) {
        val tmp = fiboArr[i]
        if (sum + tmp > target) continue
        sum += tmp
        answer.add(fiboArr[i])
        if (sum == target) return answer
    }
    return answer
}