package baekjoon.dp

private fun main() {
    val n = readLine()!!.toInt()
    var arr = ArrayList<Int>()
    for (i in 0 until n){
        val a = readLine()!!.toInt()
        var dp = LongArray(11) { 0 }

        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        if (a<4) {
            println(dp[a])
        }
        else {
            for (i in 4..a) {
                for (j in 1..3) {
                    dp[i] += dp[i - j]
                }
            }
//        arr.add(dp[a])
            println(dp[a])
        }
    }
/*    arr.forEach {
        println(it)
    }*/



}