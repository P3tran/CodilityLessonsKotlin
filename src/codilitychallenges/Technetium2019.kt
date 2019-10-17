package codilitychallenges

import java.lang.StringBuilder

class Technetium2019 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result =
                solution(arrayOf(intArrayOf(9, 9, 7), intArrayOf(9, 7, 2), intArrayOf(6, 9, 5), intArrayOf(9, 1, 2)))
            println("result :  $result")
        }

        fun solution(A: Array<IntArray>): String {
            var result = StringBuilder()
            var x = 0
            var y = 0
            result.append(A[x][y])
            while (x < A[0].size - 1 || y < A.size - 1) {
                if (!moveRight(x, y, A)) {
                    y++
                    result.append(A[y][x].toString())
                } else {
                    x++
                    result.append(A[y][x].toString())
                }
            }

            return result.toString()
        }

        fun moveRight(x: Int, y: Int, A: Array<IntArray>): Boolean {
            if (y == A.size - 1)
                return true
            if (x == A[0].size - 1)
                return false
            if (A[y + 1][x] > A[y][x + 1]) {
                return false
            } else if (A[y + 1][x] < A[y][x + 1]) {
                return true
            } else
                return moveRight(x + 1, y + 1, A)
        }

    }
}
