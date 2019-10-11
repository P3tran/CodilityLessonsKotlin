package lesson9

import kotlin.math.*

/*
* Find the maximum of 2 slices sum by calculating maximum sum forward
* and backwards and summing them.
*
* The sum of double slice (X, Y, Z) is the total of
* A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
* */

class MaxDoubleSliceSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(3, 2, -6, 4, 6))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            val forward = IntArray(A.size)
            val backwards = IntArray(A.size)

            for (i in 1 until A.size - 1) {
                forward[i] = max(forward[i - 1] + A[i], 0)
            }
            for (i in A.size - 2 downTo 1) {
                backwards[i] = max(backwards[i + 1] + A[i], 0)
            }

            var max = 0

            for (i in 1 until A.size - 1) {
                max = max(max, forward[i - 1] + backwards[i + 1])
            }

            return max
        }
    }
}