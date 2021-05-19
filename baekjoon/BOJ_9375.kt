package boj.string

private fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val clothes = HashMap<String, Int>()
        for (i in 0 until n) {
            val (name, type) = readLine()!!.split(' ')
            clothes[type] = clothes.getOrDefault(type, 0) + 1
        }
        var answer = 1
        clothes.forEach {
            answer *= it.value + 1
        }
        println(answer - 1)
    }
}

