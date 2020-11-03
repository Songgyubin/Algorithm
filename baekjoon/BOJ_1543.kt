package boj.string

private fun main(){
    var s = readLine()!!
    val search = readLine()!!
    s = s.replace(search,"0")
    println(s.count { it=='0' })
}