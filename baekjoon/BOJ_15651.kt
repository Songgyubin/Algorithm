package baekjoon.backtracking

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private lateinit var arr: IntArray
private lateinit var vis: BooleanArray

private lateinit var bw :BufferedWriter

private var n = 0
private var m = 0


private fun main(){
    bw = BufferedWriter(OutputStreamWriter(System.out))
    val a = readLine()!!.split(' ').map(String::toInt)
    n = a[0]
    m = a[1]

    arr = IntArray(m)
    vis = BooleanArray(n+1)
    backtracking(0)
    bw.flush();
    bw.close();
}

private fun backtracking(count:Int){

    if (count==m){
        for (i in 0 until m){
            bw.write("${arr[i]} ")
        }
        bw.newLine()
        return
    }
    for (i in 1..n){
        vis[i] = false
        if (!vis[i]){
            arr[count] = i
            vis[i] = true
            backtracking(count+1)
        }

    }


}