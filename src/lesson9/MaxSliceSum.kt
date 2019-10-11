package lesson9

import kotlin.math.*

/*
* Find the maximum sum slice of an array
* */

class MaxSliceSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(3, 2, -6, 4, 6))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            var max = A[0]
            var runningMax = A[0]

            for (i in 1 until A.size) {
                runningMax = max(A[i], runningMax+ A[i])
                max = max(max, runningMax)
            }
            return max
        }
    }
}