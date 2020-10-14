package boj.simulation

private val goX = intArrayOf(0, 0, -1, 1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var air: Array<Pair<Int, Int>>


private lateinit var arr: Array<IntArray>

private fun main() {
    val (r, c, t) = readLine()!!.split(' ').map { it.toInt() }
    arr = Array(r) { IntArray(c) }
    air = Array(2) { Pair(-1, -1) }

    for (i in 0 until r) {
        readLine()!!.split(' ').map { it.toInt() }.forEachIndexed { j, value ->
            arr[i][j] = value
            if (value == -1 && air[0].first == -1) {
                air[0] = Pair(i, j)
                arr[i][j] = 0 // 공기 청정기는 좌표만 저장
                // 먼지 확산 시 편하게 하기 위해 0
            } else if (value == -1 && air[0].first != -1) {
                air[1] = Pair(i, j)
                arr[i][j] = 0
            }
        }
    }
    repeat(t) {
        spreadDust(r, c)
        moveDust(r, c)
    }

    println(arr.sumBy { it.sum() })
}

private fun spreadDust(r: Int, c: Int) {
    val tmpArr = deepCopy(r, c)

    for (i in 0 until r) {
        for (j in 0 until c) {
            val dust = tmpArr[i][j] / 5
            for (k in 0 until 4) {
                val (curX, curY) = intArrayOf(i + goX[k], j + goY[k])
                if (curX < 0 || curX >= r || curY < 0 || curY >= c) continue
                if (curX == air[0].first && curY == air[0].second) continue
                if (curX == air[1].first && curY == air[1].second) continue
                arr[curX][curY] += dust
                arr[i][j] -= dust
            }
        }
    }

}

private fun moveDust(r: Int, c: Int) {
    val tmpArr = deepCopy(r, c)
    // 윗칸
    for (i in 0..air[0].first) {
        for (j in 0 until c) {

            // 맨 위
            if (i == 0) {
                if (j == c - 1) arr[i][j] = tmpArr[i + 1][j]
                else arr[i][j] = tmpArr[i][j + 1]
            }
            // 맨 아래
            else if (i == air[0].first) {
                if (j == 0) arr[i][j] = tmpArr[i - 1][j]
                else arr[i][j] = tmpArr[i][j - 1]
            }
            // 맨 왼쪽
            else if (j == 0) {
                if (i == 0) arr[i][j] = tmpArr[i][j + 1]
                else arr[i][j] = tmpArr[i - 1][j]
            }
            // 맨 오른쪽
            else if (j == c - 1) {
                if (i == air[0].first) arr[i][j] = tmpArr[i][j - 1]
                else arr[i][j] = tmpArr[i + 1][j]
            }
        }
    }
    // 청정기 아랫칸
    for (i in air[1].first until r) {
        for (j in 0 until c) {
            // 맨 위
            if (i == air[1].first) {
                if (j == 0) arr[i][j] = tmpArr[i + 1][j]
                else arr[i][j] = tmpArr[i][j - 1]
            }
            // 맨 아래
            else if (i == r - 1) {
                if (j == c - 1) arr[i][j] = tmpArr[i - 1][j]
                else arr[i][j] = tmpArr[i][j + 1]
            }
            // 맨 왼쪽
            else if (j == 0) {
                if (i == r - 1) arr[i][j] = tmpArr[i][j + 1]
                else arr[i][j] = tmpArr[i + 1][j]
            }
            // 맨 오른쪽
            else if (j == c - 1) {
                if (i == air[1].first) arr[i][j] = tmpArr[i][j - 1]
                else arr[i][j] = tmpArr[i - 1][j]
            }
        }
    }
    // 공기 정화
    arr[air[0].first][air[0].second] = 0
    arr[air[1].first][air[1].second] = 0


}

private fun deepCopy(r: Int, c: Int): Array<IntArray> {
    var tmp = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            tmp[i][j] = arr[i][j]
        }
    }


    return tmp
}