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

    backtracking(0, n, m, 0)
}

private fun backtracking(count: Int, n: Int, m: Int, idx: Int) {
    // 1 7 8 9

    if (count == m) {
        arrP.forEach {
            print("$it ")
        }
        println()
        return
    }

    for (i in idx until arr.size) {
        if (!vis[arr[i]]) {
            vis[arr[i]] = true
            arrP[count] = arr[i]
            backtracking(count + 1, n, m, i)
            vis[arr[i]] = false
        }
    }

}
