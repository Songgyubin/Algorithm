import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

// 방향
val goX = arrayOf(0, 0, -1, 1)
val goY = arrayOf(1, -1, 0, 0)
private lateinit var arr: Array<Array<Char>>
private lateinit var vis: Array<IntArray>

private var laser = ArrayList<Point>()
private var answer = Int.MAX_VALUE

private var w = 0
private var h = 0

private fun main() {
    val s = readLine()!!.split(' ').map(String::toInt)
    w = s[0]
    h = s[1]
    arr = Array(h) { Array(w) { ' ' } }
    vis = Array(h) { IntArray(w) { Int.MAX_VALUE } }

    for (i in 0 until h) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c
            if (c == 'C') laser.add(Point(i, j, -1, 0))
        }
    }
    bfs()
}

private fun bfs() {
    var queue: Queue<Point> = LinkedList()
    var c1 = laser[0] // start
    var c2 = laser[1] // end

    queue.add(c1)
    vis[c1.x][c1.y] = 0

    while (queue.isNotEmpty()) {
        val x = queue.peek().x
        val y = queue.peek().y
        val dir = queue.peek().dir
        val count = queue.peek().count
        queue.poll()
        if (x == c2.x && y == c2.y) {
            answer = min(count, answer)
        }
        for (i in 0 until 4) {
            val curX = x + goX[i]
            val curY = y + goY[i]
            val curDir = i // 방향
            if (curX < 0 || curX >= h || curY < 0 || curY >= w || arr[curX][curY] == '*') continue
            var tmp = count
            if (dir != curDir && dir != -1) {
                tmp++
            }
            if (vis[curX][curY] < tmp) continue

            vis[curX][curY] = tmp
            queue.add(Point(curX, curY, curDir, tmp))
        }
    }
    println(answer)
}

data class Point(val x: Int, val y: Int, val dir: Int, val count: Int)
