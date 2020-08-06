package backtracking

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private lateinit var arr: IntArray
private lateinit var arrP: IntArray
private lateinit var vis: IntArray

private var n = 0
private var m = 0


private lateinit var bw: BufferedWriter

private fun main() {


    val s = readLine()!!.split(' ').map(String::toInt)
    n = s[0]
    m = s[1]
    bw = BufferedWriter(OutputStreamWriter(System.out))
    arr = IntArray(n)
    arrP = IntArray(m)
    vis = IntArray(11)

    readLine()!!.split(' ').map(String::toInt).forEachIndexed { index, value ->
        vis[value]++
        arr[index] = value
    }

    arr = arr.distinct().toIntArray()
    arr.sort()


    backtracking(0)
    bw.flush()
    bw.close()
}

private fun backtracking(count: Int) {
    if (count == m) {
        arrP.forEach {
            bw.write("$it ")
        }
        bw.newLine()
        return
    }
    for (i in arr.indices) {
        if (vis[arr[i]] != 0) {
            arrP[count] = arr[i]
            backtracking(count + 1)
        }
    }

}