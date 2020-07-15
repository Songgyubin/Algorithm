package bfs

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>
private lateinit var arrP: ArrayList<Int>
private var answer = 0


private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private fun main() {
    val (m, n, k) = readLine()!!.split(' ').map(String::toInt)

    arr = Array(m) { IntArray(n) }
    vis = Array(m) { BooleanArray(n) }
    arrP = ArrayList()
    for (i in 0 until k){
       val sep= readLine()!!.split(' ').map(String::toInt)
        seperateArr(sep)
    }
    bfs(m,n)
    println(answer)
    arrP.sort()
    arrP.forEach {
        print("$it ")
    }

}

private fun bfs(m:Int,n:Int) {

    var queue:Queue<Pair<Int,Int>> = LinkedList()
    for (i in 0 until m){
        for (j in 0 until n){
            if (arr[i][j]==0 && !vis[i][j]){
                var tmpAnwer = 0
                tmpAnwer++
                answer++
                queue.add(Pair(i,j))
                vis[i][j] = true
                while (queue.isNotEmpty()){
                    var x = queue.peek().first
                    var y = queue.peek().second
                    queue.poll()
                    for (k in 0 until 4){
                        var curX = x+ goX[k]
                        var curY = y+ goY[k]
                        if (curX>=0 && curX<m && curY>=0 && curY<n && arr[curX][curY]==0 && !vis[curX][curY]){
                            queue.add(Pair(curX,curY))
                            vis[curX][curY] = true
                            tmpAnwer++
                        }
                    }
                }
                arrP.add(tmpAnwer)
            }

        }
    }


}
private fun seperateArr(sep:List<Int>){
    for (i in sep[1] until sep[3]){ // y
        for (j in sep[0] until sep[2]){ // x
            arr[i][j] = 1
        }
    }
}