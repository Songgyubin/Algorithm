package boj

import java.util.ArrayList

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<Array<ArrayList<Pair<Int, Int>>>>
private lateinit var moves: Array<BooleanArray>
private lateinit var vis2: Array<BooleanArray>
private lateinit var lights: Array<IntArray>
private var flag = false

private var answer = 0

private fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    arr = Array(n + 1) { Array(n + 1) { ArrayList() } }
    moves = Array(n + 1) { BooleanArray(n + 1) }
    vis2 = Array(n + 1) { BooleanArray(n + 1) }
    lights = Array(n + 1) { IntArray(n + 1) }

    for (i in 0 until m) {
        val (x, y, a, b) = readLine()!!.split(' ').map { it.toInt() }
        arr[x][y].add(Pair(a, b))
    }
    moves[1][1] = true
    lights[1][1] = 1
    turnOn(1, 1)

    while (true) {
        flag = false
        vis2 = Array(n + 1) { BooleanArray(n + 1) }
        dfs(1, 1, n)
        if (!flag) break
    }

    lights.forEach { answer += it.count { it == 1 } }
    println(answer)
}

private fun turnOn(x: Int, y: Int) {
    for (i in 0 until arr[x][y].size) {
        val (a, b) = arr[x][y][i]
        lights[a][b] = 1
    }
}

private fun dfs(x: Int, y: Int, n: Int) {
    if (!moves[x][y]) {
        flag = true
        moves[x][y] = true
        turnOn(x, y)
    }
    vis2[x][y] = true
    for (i in 0 until 4) {
        val (nx, ny) = intArrayOf(x + goX[i], y + goY[i])
        if (nx < 1 || nx > n || ny < 1 || ny > n) continue
        if (lights[nx][ny] == 0 || vis2[nx][ny]) continue

        vis2[nx][ny] = true
        dfs(nx, ny, n)
    }
}