package leetcode

class PascalTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(5)
            println("result :  $result")

        }

        fun solution(numRows: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            for (i in 1..numRows) {
                if (i > 1)
                    result.add(createRowFor(i, result[i - 2]))
                else
                    result.add(createRowFor(i, listOf(1)))
            }
            return result
        }

        private fun createRowFor(rowNum: Int, previousRow: List<Int>): List<Int> {
            val row = mutableListOf<Int>()
            row.add(1)
            if (rowNum > 2) {
                for (i in 1 until previousRow.size) {
                    row.add(previousRow[i] + previousRow[i - 1])
                }
            }
            if (rowNum > 1)
                row.add(1)
            return row
        }
    }
}