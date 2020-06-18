package baekjoon.dp

private fun main() {
    val n = readLine()!!.toInt()
    // -1 : 닫 , 0 : 열


    for (i in 0 until n) {
        val m = readLine()!!.toInt()
        var dp = IntArray(m + 1) { -1 }
        for (j in 1..m) {
            for (k in 1..m) {
                if (j*k>m) continue
                if (dp[j*k]== -1){
                    dp[j*k] =0
                }
                else if (dp[j*k]== 0){
                    dp[j*k] =-1
                }
            }
        }
        println(dp.count{it==0})
    }

}