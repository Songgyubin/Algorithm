package baekjoon.study.dp1

private fun main(){
// 4
    val (a,b) = readLine()!!.split(' ').map(String::toInt)
    // 초콜릿 하나만 남을때까지 쪼개면 되므로
    println((a*b)-1)

}