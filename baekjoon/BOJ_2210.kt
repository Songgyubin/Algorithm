package backtracking

private val goX = intArrayOf(-1, 1, 0, 0)
private val goY = intArrayOf(0, 0, -1, 1)

private var arr = Array(5) { Array<String>(5) { "" } }
private var arrP = ArrayList<String>()

private fun main() {
    for (i in 0 until 5) {
        arr[i] = readLine()!!.split(' ').toTypedArray()
    }
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            dfs(i, j, 1, arr[i][j])
        }
    }

    println(arrP.distinct().size)
}

private fun dfs(x: Int, y: Int, count: Int, word: String) {
    if (count == 6) {
        arrP.add(word)
        return
    }
    for (i in 0 until 4) {
        val curX = x + goX[i]
        val curY = y + goY[i]
        if (curX >= 0 && curX < 5 && curY >= 0 && curY < 5) {
            dfs(curX, curY, count + 1, word + arr[curX][curY])
        }
    }

}