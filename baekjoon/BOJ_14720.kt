package boj

private fun main(){
    readLine()!!.toInt()
    var count = 0
    var next = 0
    readLine()!!.split(' ').map { it.toInt() }.forEach {
        if (it==next){
            count++
            next = (next+1) % 3
        }
    }
    println(count)
}