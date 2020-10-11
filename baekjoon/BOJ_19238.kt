package boj.bfs

import java.util.*
import kotlin.collections.ArrayList

private lateinit var taxiMap: Array<IntArray>
private val passengerMap = ArrayList<Passenger>()
private val nodeMap = ArrayList<Taxi>()
private val dx = intArrayOf(-1, 0, 0, 1)
private val dy = intArrayOf(0, -1, 1, 0)
private var answer = 0
private fun main() {
    val input = System.`in`.bufferedReader()
    val (n, m, k) = input.readLine().split(" ").map { it.toInt() }
    answer = k
    taxiMap = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val row = input.readLine().split(" ").map { it.toInt() }
        for (j in 1..row.size) {
            taxiMap[i][j] = row[j - 1]
            if (taxiMap[i][j] == 1) taxiMap[i][j] = -1
        }
    }
    var (TX, TY) = input.readLine().split(" ").map { it.toInt() }
    for (i in 0 until m) {
        val row = input.readLine().split(" ").map { it.toInt() }
        passengerMap.add(Passenger(row[0], row[1], row[2], row[3]))
        taxiMap[row[0]][row[1]] = i + 1
    }
    while (true) {
        if (passengerMap.size == 0) {
            println(answer)
            return
        }
        nodeMap.clear()
        findPassenger(TX, TY)
        if (nodeMap.size == 0) {
            println(-1)
            return
        }
        val node = nodeMap[0]
        taxiMap[node.x][node.y] = 0
        answer -= node.dist
        if (answer < 0) {
            println(-1)
            return
        }
        var dist = 0
        for (i in passengerMap.indices) {
            val passenger = passengerMap[i]
            if (passenger.x == node.x && passenger.y == node.y) {
                dist = findDestination(passenger)
                if (dist == -1) {
                    println(-1)
                    return
                }
                TX = passenger.dx
                TY = passenger.dy
                passengerMap.remove(passenger)
                break
            }
        }
        answer -= dist
        if (answer < 0) {
            println(-1)
            return
        }
        answer += dist * 2
    }
}

private fun findDestination(passenger: Passenger): Int {
    val queue: Queue<Taxi> = LinkedList()
    val visited = Array(taxiMap.size) { BooleanArray(taxiMap.size) }
    queue.add(Taxi(passenger.x, passenger.y, 0))
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.x == passenger.dx && q.y == passenger.dy) {
            return q.dist
        }
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 1 || ny < 1 || nx >= taxiMap.size || ny >= taxiMap.size) continue
            if (visited[nx][ny]) continue
            if (taxiMap[nx][ny] == -1) continue
            visited[nx][ny] = true
            queue.add(Taxi(nx, ny, q.dist + 1))
        }
    }
    return -1
}

private fun findPassenger(x: Int, y: Int) {
    val queue = PriorityQueue<Taxi>()
    queue.add(Taxi(x, y, 0))
    val visited = Array(taxiMap.size) { BooleanArray(taxiMap.size) }
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (taxiMap[q.x][q.y] >= 1) {
            nodeMap.add(Taxi(q.x, q.y, q.dist))
            break
        }
        for (i in 0 until 4) {
            val nx = q.x + dx[i]
            val ny = q.y + dy[i]
            if (nx < 1 || ny < 1 || nx >= taxiMap.size || ny >= taxiMap.size) continue
            if (visited[nx][ny]) continue
            if (taxiMap[nx][ny] == -1) continue
            visited[nx][ny] = true
            queue.add(Taxi(nx, ny, q.dist + 1))
        }
    }
}

private data class Taxi(
        val x: Int,
        val y: Int,
        val dist: Int
) : Comparable<Taxi> {
    override fun compareTo(other: Taxi): Int {
        return if (this.dist != other.dist) {
            this.dist - other.dist
        } else {
            if (this.x != other.x) {
                this.x - other.x
            } else {
                this.y - other.y
            }
        }
    }
}

private data class Passenger(
        val x: Int,
        val y: Int,
        val dx: Int,
        val dy: Int
)