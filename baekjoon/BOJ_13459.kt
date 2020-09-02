package bfs

import java.util.*
import kotlin.math.abs
import kotlin.system.exitProcess

private val goX = intArrayOf(-1, 1, 0, 0)
private val goY = intArrayOf(0, 0, -1, 1)

private lateinit var arr: Array<CharArray>
private lateinit var vis: Array<Array<Array<BooleanArray>>>


private lateinit var hole: Pair<Int, Int>

private lateinit var ball: Ball
private fun main() {

    val (n, m) = readLine()!!.split(' ').map(String::toInt)

    arr = Array(n) { CharArray(m + 1) }
    vis = Array(11) { Array(11) { Array(11) { BooleanArray(11) } } }

    ball = Ball(0, 0, 0, 0, 0)


    for (i in 0 until n) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c
            if (c == 'R') {
                ball.rx = i
                ball.ry = j
            }
            if (c == 'B') {
                ball.bx = i
                ball.by = j
            }
            if (c == 'O') hole = Pair(i, j)
        }
    }
    // 10번 이하로 빨간 구승를 구멍을 통해 빼낼 수 있는지 ?
    bfs()
    println(0)
}

private fun bfs() {
    val queue: Queue<Ball> = LinkedList()
    queue.add(ball)
    vis[ball.rx][ball.ry][ball.bx][ball.by] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        if (cur.count > 10) break
        if (arr[cur.rx][cur.ry] == 'O' && arr[cur.bx][cur.by] != 'O') {
            println(1)
            exitProcess(0)
        }
        for (i in 0 until 4) {
            var nextRx = cur.rx
            var nextRy = cur.ry
            var nextBx = cur.bx
            var nextBy = cur.by

            while (true) {
                if (arr[nextRx][nextRy] == '#') {
                    nextRx -= goX[i]
                    nextRy -= goY[i]
                    break
                }
                if (arr[nextRx][nextRy] == 'O') break

                nextRx += goX[i]
                nextRy += goY[i]
            }

            while (true) {
                if (arr[nextBx][nextBy] == '#') {
                    nextBx -= goX[i]
                    nextBy -= goY[i]
                    break
                }
                if (arr[nextBx][nextBy] == 'O') break

                nextBx += goX[i]
                nextBy += goY[i]
            }
            if (nextRx == nextBx && nextRy == nextBy) {
                if (arr[nextRx][nextRy]!='O'){
                    val r_dist = abs(nextRx-cur.rx) + abs(nextRy-cur.ry)
                    val b_dist = abs(nextBx-cur.bx) + abs(nextBy-cur.by)
                    if (r_dist> b_dist){
                        nextRx -= goX[i]
                        nextRy -= goY[i]
                    }
                    else{
                        nextBx -= goX[i]
                        nextBy -= goY[i]
                    }
                }
            }
            if (!vis[nextRx][nextRy][nextBx][nextBy]) {
                vis[nextRx][nextRy][nextBx][nextBy] = true
                queue.add(Ball(nextRx, nextRy, nextBx, nextBy, cur.count + 1))
            }


        }


    }

}
