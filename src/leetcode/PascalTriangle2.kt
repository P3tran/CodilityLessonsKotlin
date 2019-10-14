package leetcode

class PascalTriangle2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(5)
            println("result :  $result")

        }

        fun solution(numRows: Int): List<Int> {
            var previousRow = createRowFor(1, listOf(1))
            for (i in 2..numRows+1) {

                previousRow = createRowFor(i, previousRow)
            }
            return previousRow
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