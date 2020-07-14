package baekjoon.backtracking

private lateinit var arr: IntArray
private lateinit var vis: BooleanArray

private var n = 0
private var m = 0

private fun main() {

    val a = readLine()!!.split(' ').map(String::toInt)
    n = a[0]
    m = a[1]

    arr = IntArray(m)
    vis = BooleanArray(n + 1)

    backtracking(0, 0)
}

private fun backtracking( idx: Int,count: Int) {
    if (count == m) {
        for (i in 0 until m) {
            print("${arr[i]} ")
        }
        println()
        return
    }
    for (i in (idx + 1)..n) {
        if (!vis[i]) {
            vis[i] = true
            arr[count] = i
            backtracking( i,count + 1)
            vis[i] = false
        }
    }
}