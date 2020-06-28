package programmers

private fun main() {

    println(
        solution(
            arrayOf(
                arrayOf("100", "ryan", "music", "2"),
                arrayOf("200", "apeach", "math", "2"),
                arrayOf("300", "tube", "computer", "3"),
                arrayOf("400", "con", "computer", "4"),
                arrayOf("500", "muzi", "music", "3"),
                arrayOf("600", "apeach", "music", "2")

            // ryanmusic
            // apeachmath
            // tube
            )
        )
    )

}

private fun solution(relation: Array<Array<String>>): Int {
    var answer = 0

    val row = relation.size
    val col = relation[0].size

    val unique = ArrayList<String>()
    var columnArrayList = ArrayList<Key>()

    var tmpRelation = relation.toMutableList()


    // unique 있는 애들만 일단 ++

    // true 1 false 0
    for (i in 0 until col) {

        for (j in 0 until row) {
            unique.add(relation[j][i])
        }
        if (unique.distinct().count() == row) {
            columnArrayList.add(Key(i, true))
            answer++
        } else columnArrayList.add(Key(i, false))

        unique.clear()
    }
        var minimal = ArrayList<String>()
        for( i in 0 until col){
            if (columnArrayList[i].isUnique) break

        }


    return answer
}

data class Key(val index: Int, val isUnique: Boolean)