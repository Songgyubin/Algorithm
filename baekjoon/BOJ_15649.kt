package baekjoon.backtracking


private fun main() {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    var arr  = IntArray(m)
    var vis = BooleanArray(n+1)

    backtracking(arr,vis,n,m,0)

}

private fun backtracking(arr:IntArray,vis:BooleanArray,n:Int,m:Int,count:Int){

    if (count==m){
        for (i in 0 until m){
            print("${arr[i]} ")
        }
        println()
        return
    }
    for (i in 1..n ){
        if (!vis[i]) {
            vis[i] = true
            arr[count] = i
            backtracking(arr, vis, n, m, count + 1)
            vis[i] = false
        }

    }


}

