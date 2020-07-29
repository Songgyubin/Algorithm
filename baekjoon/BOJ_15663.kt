package backtracking

private lateinit var arr: IntArray
private lateinit var arrP: IntArray
private lateinit var vis: IntArray
private var n = 0
private var m = 0
private fun main() {
    val s = readLine()!!.split(' ').map(String::toInt)

    n = s[0]
    m = s[1]
    vis = IntArray(10001)
    arr = IntArray(n)
    readLine()!!.split(' ').map(String::toInt).forEachIndexed { index, i ->
        arr[index] = i
        vis[i]++
    }
    arr = arr.sorted().distinct().toIntArray()
    arrP = IntArray(m)
    backtracking(0)

}

// m = 2
// 1 7 9
private fun backtracking(count: Int) {
    if (count == m) {
        arrP.forEach { print("$it ") }
        println()
        return
    }
    for (i in 0 until arr.size) {
        if (vis[arr[i]] != 0) {
            vis[arr[i]]--
            arrP[count] = arr[i]
            backtracking(count + 1)
            vis[arr[i]]++
        }
    }
}
