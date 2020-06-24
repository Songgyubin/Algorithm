package baekjoon.study.dp2

private fun main() {

    val a = readLine()!!

    var dp = LongArray(a.length + 1) { 0 }
    // dp[n] = n번째 문자까지 나올 수 있는 암호 해석 수
    dp[0] = 1
    dp[1] = 1

    if (a[0] == '0') {
        println(0)
        return
    }
    for (i in 1 until a.length) {
      var pre = a[i-1]
        if (a[i] in '1'..'9'){
            dp[i+1] += dp[i]
            dp[i+1] = dp[i+1]%1000000
        }
        if (!(pre=='0' || pre>'2' || (pre=='2' && a[i]>'6'))){
            dp[i+1] += dp[i-1]
            dp[i+1] = dp[i+1]%1000000
        }
        dp[i+1] = dp[i+1] % 1000000
    }

    println(dp[a.length]%1000000)

}