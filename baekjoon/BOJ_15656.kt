package baekjoon.backtracking

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private lateinit var arrP: IntArray
private lateinit var vis: BooleanArray

private lateinit var arr: IntArray

private lateinit var bw : BufferedWriter

private var n = 0
private var m = 0
private fun main() {

    bw = BufferedWriter(OutputStreamWriter(System.out))
    val a = readLine()!!.split(' ').map(String::toInt)
    n = a[0]
    m = a[1]
    arrP = IntArray(m)
    arr = IntArray(n)
    vis = BooleanArray(10001)

    readLine()!!.split(' ').map(String::toInt).forEachIndexed { index, v ->
        arr[index] = v
    }
    arr.sort()
    backtracking(0, n, m)
    bw.flush()
    bw.close()
}

private fun backtracking(count: Int, n: Int, m: Int) {

    if (count == m) {
        for (i in arrP.indices){
            bw.write("${arrP[i]} ")
        }
        bw.newLine()
        return
    }

    for (i in arr) {
        vis[i] = false
        if (!vis[i]) {
            arrP[count] = i
            vis[i] = true
            backtracking(count + 1, n, m)
        }
    }

}
