package programmers

private fun main() {
    println(solution(intArrayOf(93,30,55), intArrayOf(1,30,5)).size)
    // 2, 1
}

private fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()

    var tmpAnswer = 0

    var tmpDay = calcDay(progresses[0],speeds[0])

    progresses.forEachIndexed { index, value->
        var a = calcDay(value,speeds[index])

        if (a <= tmpDay) {

            tmpAnswer++
        }
        else if (a > tmpDay){

            answer.add(tmpAnswer)
            tmpAnswer = 0
            tmpDay = a
            tmpAnswer++
        }
         if (index == progresses.lastIndex){

            answer.add(tmpAnswer)
        }
    }

    return answer.toIntArray()
}
fun calcDay(progress:Int,speed:Int):Int{
    return if((100-progress)%speed==0) (100-progress)/speed
    else ((100-progress)/speed)+1
}