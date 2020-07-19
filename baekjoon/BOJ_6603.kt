package backtracking

private lateinit var arr:IntArray
private lateinit var vis:BooleanArray
private var n = 0

private fun main(){
    while (true){
        val s = readLine()!!
        if (s=="0") return

        s.split(' ').map(String::toInt).forEachIndexed { index, v ->
            if (index==0) {
                n=v
                arr = IntArray(n)
                vis = BooleanArray(n)
            }
            else arr[index - 1] = v

        }
        backTracking(0,0)
        println()
    }
}
private fun backTracking(start:Int,count:Int){
    if (count == 6){
        for (i in 0 until n){
            if (vis[i])
            print("${arr[i]} ")
        }
        println()
    }

    for (i in start until n){
        vis[i] = true
        backTracking(i+1,count+1)
        vis[i] = false
    }

}