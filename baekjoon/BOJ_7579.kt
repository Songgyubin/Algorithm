package baekjoon.study.dp1

private fun main(){
    val (n,m) = readLine()!!.split(' ').map(String::toInt)

    var memory = ArrayList<Int>()
    var cost = ArrayList<Int>()
    var dp = Array(n){IntArray(10001)}
    var answer = Integer.MAX_VALUE

    readLine()!!.split(' ').map(String::toInt).forEach {
        memory.add(it)
    }
    readLine()!!.split(' ').map(String::toInt).forEach {
        cost.add(it)
    }
    for (i in 0 until n){
        var cost = cost[i]
        var memory = memory[i]


        for (j in 0..10000){
            if (i ==0){
                if (j>= cost) dp[i][j] = memory
            }
            else{
                if (j>=cost) dp[i][j] = Math.max(dp[i-1][j-cost]+memory,dp[i-1][j])
                else dp[i][j] = dp[i-1][j]
            }
            if (dp[i][j] >= m) answer = Math.min(answer,j)
        }

    }

    println(answer)
}
