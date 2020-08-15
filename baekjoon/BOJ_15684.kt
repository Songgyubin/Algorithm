package bruteforce

var bridge = Array<Array<Boolean>>(30, {Array<Boolean>(10, {false})})
var ans = -1

private fun check(n: Int, h: Int): Boolean {
    for(i in 0 until n) {
        var pos = i
        for(j in 0 until h) {
            if(bridge[j][pos]) {
                pos += 1
            } else if(pos - 1 >= 0 && bridge[j][pos - 1]) {
                pos -= 1
            }
        }
        if(pos != i) {
            return false
        }
    }

    return true
}

fun dfs(n: Int, h: Int, cnt: Int, lim: Int) {
    if(cnt >= lim) {
        if(check(n, h)) {
            ans = cnt
        }
        return
    }

    for(i in 0 until n - 1) {
        for(j in 0 until h) {
            if(!bridge[j][i] && (i - 1 < 0 || !bridge[j][i - 1]) && (i + 1 >= h || !bridge[j][i + 1])) {
                bridge[j][i] = true
                dfs(n, h, cnt + 1, lim)
                bridge[j][i] = false
            }
        }
    }
}

private fun main() {
    val (n, m, h) = readLine()!!.split(" ").map {it.toInt()}
    for(i in 0 until m) {
        val (th, tp) = readLine()!!.split(" ").map {it.toInt()}
        bridge[th - 1][tp - 1] = true
    }

    for(i in 0 until 4) {
        dfs(n, h, 0, i)
        if(ans != -1) {
            break
        }
    }

    println(ans)
}