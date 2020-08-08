package dfs

private lateinit var arr: Array<IntArray>
private lateinit var vis: BooleanArray
private fun main() {
    var answer = 0
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n + 1) { IntArray(n + 1) }
    vis = BooleanArray(n + 1)
    for (i in 0 until m) {
        val s = readLine()!!.split(' ').map(String::toInt)
        arr[s[0]][s[1]] = 1
        arr[s[1]][s[0]] = 1
    }
    for (i in 1..n) {
        if (!vis[i]) {
            dfs(n,i)
            answer++
        }
    }
    println(answer)
}

private fun dfs(n:Int,v: Int) {
    if (vis[v]==true) return

    vis[v] = true
    for (i in 1..n) {
        if (arr[v][i]==1) {
            dfs(n,i)
        }
    }
}