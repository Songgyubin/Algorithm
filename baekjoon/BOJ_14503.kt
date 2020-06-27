package baekjoon.study.simulation


private lateinit var arr: Array<IntArray>

val goX = intArrayOf(-1, 0, 1, 0) // 서 북 동 남
val goY = intArrayOf(0, 1, 0, -1) // 왼쪽보고(북 동 남 서) 직진

var r = 0
var c = 0
var d = 0
var turnCount = 0
private fun main() {

    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }

    val s = readLine()!!.split(' ').map(String::toInt)
    r = s[0]
    c = s[1]
    d = s[2]


    for (i in 0 until n) {
        readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
            arr[i][j] = value
        }
    }
    robotMoves()

}

private fun robotMoves() {

    if (arr[r][c] != 0) {
        println(0)
        return
    }


    while (true) {

        //0 북 1 동 2 남 3 서
        if (turnCount == 4) {
            var backX = r - goX[d]
            var backY = c - goY[d]

            if (arr[backX][backY] == 1) {
                println(getCleanArea())
                return
            } else {
                setRobot(backX, backY, d, 0)
            }
        }


        if (arr[r][c] == 0) arr[r][c] = 2



        var tmpD = (d + 3) % 4
        var tmpX = r + goX[tmpD]
        var tmpY = c + goY[tmpD]

        if (arr[tmpX][tmpY] == 0) {
            setRobot(tmpX,tmpY,tmpD,0)
        } else {
            setRobot(r,c,tmpD, turnCount+1)
        }
    }
}

fun setRobot(nextX: Int, nextY: Int, nextD: Int, nextCount: Int) {
    r =nextX
    c = nextY
    d = nextD
    turnCount = nextCount

}

private fun getCleanArea(): Int {
    var result = 0
    for (i in arr.indices) {
        result += arr[i].count { it == 2 }
    }
    return result
}