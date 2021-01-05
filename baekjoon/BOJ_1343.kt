package boj.greedy

private fun main(){
    // AAAA BB
    val s = readLine()!!.replace("XXXX","AAAA").replace("XX","BB")
    if (s.contains("X")) println(-1)
    else println(s)

}