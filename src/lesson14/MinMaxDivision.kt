package lesson14

import kotlin.math.abs
import kotlin.math.min

class MinMaxDivision {

    companion object {

        data class Plank(val start: Int, val end: Int)

        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(3, 5, intArrayOf(2, 1, 5, 1, 2, 2, 2))
            println("result :  $result")

        }

        fun solution(K: Int, M: Int, A: IntArray): Int {
            val sums = IntArray(A.size)
            sums[0] = A[0]
            for (i in 1 until A.size) {
                sums[i] = A[i] + sums[i - 1]
            }

            var minLargeSum = Integer.MAX_VALUE
            var sliceAmount = 0
            if (A.size.rem(K) == 0)
                sliceAmount = A.size / K
            else
                sliceAmount = A.size / K + 1

            for (i in 0 until A.size - sliceAmount) {
                minLargeSum = min(minLargeSum, abs(sums[i] - sums[i + sliceAmount]))
            }
            return minLargeSum
        }
    }
}