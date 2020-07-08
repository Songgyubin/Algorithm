package programmers

private fun main(){
    solution(intArrayOf(1,2,3,4))
}
private fun solution(nums: IntArray): Int {
    var answer = 0

    // 1 2 3
    // 1 2 4
    // 2 3 4 요런식으로 순차적으로 전체를 탐색하기위해
    for(i in 0 until nums.size-2){
        for (j in (i+1) until nums.size-1){
            for (k in (j+1) until nums.size){
                if(isPrimeNumber(nums[i]+nums[j]+nums[k]))
                    answer++
            }
        }
    }
    return answer
}

// 소수 판별
fun isPrimeNumber(i:Int):Boolean{

    for (j in 1 until i){
        if(i%j == 0 && j!=1) {
            return false
        }
    }
    return true
}