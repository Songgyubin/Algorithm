package boj.string

private fun main() {

    //	c= , c- , dz= , d- : 1 , lj : 2 , nj : 2 , s= : 1 , z= : 1
    val s = readLine()!!.replace("c=", "1").replace("c-", "1").replace("dz=", "1").replace("d-", "1").replace("lj", "1")
        .replace("nj", "1").replace("s=", "1").replace("z=", "1")
    println(s.length)


}