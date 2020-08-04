package greedy

private fun main() {

    val s = readLine()!!.replace("XXXX","AAAA").replace("XX","BB")
    println(if('X' in s) "-1" else s)
}