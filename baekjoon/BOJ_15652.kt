package baekjoon.backtracking

private fun main(){
    val (n,m) = readLine()!!.split(' ').map(String::toInt)
    var arr = IntArray(m)

    backtracking(arr,0,n,m)
}
private fun backtracking(arr:IntArray,k:Int,n:Int,m:Int){
    if (k==m){
        for (i in 0 until m){
            print("${arr[i]+1} ")
        }
        println()
        return
    }
    var st = 0
    if (k!=0) st = arr[k-1]

    for (i in st until n){
        arr[k] = i
        backtracking(arr,k+1,n,m)
    }

}