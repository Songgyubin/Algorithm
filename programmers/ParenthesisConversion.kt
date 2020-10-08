package programmers


fun balacedIndex(p:String):Int{
    var count = 0
    for (i in p.indices){
        if (p[i]=='(') count++
        else count--
        if (count==0) return i
    }
    return -1
}

 fun checkRight(p:String):Boolean{
    var count =0
    for (i in p.indices){
        if (p[i]=='(') count++
        else{
            if (count==0){
                return false
            }
            count--
        }
    }
    return true
}
 fun solution(p:String):String{
    var answer =""
    if (p=="") return answer
    var index = balacedIndex(p)
    var u = p.substring(0,index+1)
    var v = p.substring(index+1)

    if (checkRight(u)){
        answer+= u+ solution(v)
    }
    else{
        answer +="("
        answer+= solution(v)
        answer+=")"
        var tmp=""
        u = u.substring(1,u.lastIndex)
        for (i in u.indices){
            if (u[i]=='(') tmp+=")"
            else tmp+="("
        }
        answer+=tmp
    }
    return answer
}