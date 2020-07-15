package baekjoon.backtracking

private lateinit var arrP: IntArray
private lateinit var vis: BooleanArray

private lateinit var arr: IntArray

private fun main() {

    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arrP = IntArray(m)
    arr = IntArray(n)
    vis = BooleanArray(10001)

    readLine()!!.split(' ').map(String::toInt).forEachIndexed { index, v ->
        arr[index] = v
    }
    arr.sort()

    backtracking(0, n, m)

}

private fun backtracking(count: Int, n: Int, m: Int) {

    if (count == m) {
        arrP.forEach {
            print("${it} ")
        }
        println()
        return
    }
    for (i in arr) {
        if (!vis[i]) {
            vis[i] = true
            arrP[count] = i
            backtracking(count + 1, n, m)
            vis[i] =false
        }
    }

}