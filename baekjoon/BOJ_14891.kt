package baekjoon.study.simulation


private lateinit var gear: Array<IntArray>
private fun main() {

    gear = Array(4) { IntArray(8) }
    var answer = 0
    for (i in 0 until 4) {
        readLine()!!.map(Char::toString).forEachIndexed { j, s ->
            gear[i][j] = s.toInt()
        }
    }

    var rotation = readLine()!!.toInt()
    for (i in 0 until rotation) {
        val (idx, dir) = readLine()!!.split(' ').map(String::toInt)

        rotateGear(idx - 1, dir)
    }

    gear.forEachIndexed { index, ints ->
        if (index == 0 && ints[0] == 1) {
            answer += 1

        }
        if (index == 1 && ints[0] == 1) {
            answer += 2

        }
        if (index == 2 && ints[0] == 1) {
            answer += 4

        }
        if (index == 3 && ints[0] == 1) {
            answer += 8

        }
    }
    println(answer)
}

private fun rotateGear(idx: Int, dir: Int) {
    left(idx - 1, -dir)
    right(idx + 1, -dir)
    rotate(idx, dir)
}


private fun rotate(idx: Int, dir: Int) {
    // r== 1 시계 r==-1 반시계
    if (dir == 1) {
        val tmp = gear[idx][7]
        for (i in 7 downTo 1) {
            gear[idx][i] = gear[idx][i - 1]
        }
        gear[idx][0] = tmp
    } else {
        val tmp = gear[idx][0]
        for (i in 0 until 7) {
            gear[idx][i] = gear[idx][i + 1]
        }
        gear[idx][7] = tmp
    }
}

private fun right(idx: Int, dir: Int) {
    if (idx > 3) return
    if (gear[idx][6] != gear[idx - 1][2]) {
        right(idx + 1, -dir)
        rotate(idx, dir)
    }
}

//idx-1
private fun left(idx: Int, dir: Int) {
    if (idx < 0) return
    if (gear[idx][2] != gear[idx + 1][6]) {
        left(idx - 1, -dir)
        rotate(idx, dir)
    }
}