package baekjoon.stack

import java.util.*

private fun main(){

    while (true){
          val a = readLine()!!
          if (a.isEmpty()){
              println(" ")
              break
          }
          if (mySolution(a)) println("yes")
          else if (!mySolution(a)) println("no")
      }
}
private fun mySolution(s:String):Boolean{
    var stack= Stack<Char>()
    s.forEach {
        when(it){
            '(' -> stack.push(it)
            '[' -> stack.push(it)
            ']' -> if (stack.isEmpty() || stack.peek()=='(') return false else stack.pop()
            ')' -> if (stack.isEmpty() || stack.peek()=='[') return false else stack.pop()
        }
    }
    return stack.isEmpty()
}