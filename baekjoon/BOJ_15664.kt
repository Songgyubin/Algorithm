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
    arr = IntArray(n)
    vis = IntArray(11)
    arrP = IntArray(m)
    readLine()!!.split(' ').map(String::toInt).forEachIndexed { index, i ->
        vis[i]++
        arr[index] = i

    }
    arr.sort()
    arr = arr.distinct().toIntArray()
    backtracking(0, 0)

}

private fun backtracking(count: Int, start: Int) {
    if (count == m) {
        arrP.forEach { print("$it ") }
        println()
        return
    }
    for (i in start until arr.size) {

        if (vis[arr[i]] != 0) {
             vis[arr[i]]--

            arrP[count] = arr[i]
            backtracking(count + 1, i)

                vis[arr[i]]++
        }

    }


}