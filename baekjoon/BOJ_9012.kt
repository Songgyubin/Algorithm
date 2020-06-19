import java.util.*
private fun main(){
    var sc = Scanner(System.`in`)
    var n = sc.nextInt()
    var arr = Array(n){sc.next()}

    arr.forEach {
        if(isVPS(it)) println("YES")
        else println("NO")
    }

}
private fun isVPS(s:String):Boolean{
    var st = Stack<Char>()
    s.forEach {
        if(it == '(') st.push(it)
        else{
            if(st.empty()) return false
            else st.pop()
        }
    }
    return st.empty()
}