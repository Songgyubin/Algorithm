package backtracking

import java.util.*


private lateinit var arr: Array<Char>
private lateinit var arrP: Array<Char>
private lateinit var vis: BooleanArray

private var l = 0
private var c = 0

private fun main() = with(Scanner(System.`in`)) {
    l = nextInt()
    c = nextInt()
    arr = Array<Char>(c) { next()[0] }
    vis = BooleanArray('z'.toInt() + 1)
    arrP = Array(l) { ' ' }
    arr.sort()
    backTracking(0, 0)
}

private fun backTracking(count: Int, start: Int) {
    if (count == l) {
        if (isAnswer(arrP)) {
            for (i in arrP) {
                print("$i")
            }
            println()
        }
        return
    }
    for (i in start until arr.size) {

        if (!vis[arr[i].toInt()]) {
            vis[arr[i].toInt()] = true
            arrP[count] = arr[i]
            backTracking(count + 1, i)
            vis[arr[i].toInt()] = false
        }
    }
}


// 모음 한개이상 자음 두개 이상이 들어있는지 체크
private fun isAnswer(arrP: Array<Char>): Boolean {

    val v = listOf('a', 'e', 'i', 'o', 'u')
    var answer = false
    var tmp = 0
    for (i in arrP) {
        if (v.contains(i)) tmp++
    }
    if (tmp >= 1 && tmp <= l - 2) answer = true

    return answer
}