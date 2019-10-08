package lesson3

import kotlin.math.abs

/*
* Find the minimum difference between the slices of the array
* */

class TapeEquilibrium {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(1, 2, 3, 5, 4, 7, 8, 6))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            val total = A.sum()
            var runningSum = 0
            var minDifference = Integer.MAX_VALUE
            var currentDifference: Int

            for (i in 0 until A.size - 1) {
                runningSum += A[i]
                currentDifference = abs(runningSum - (total - runningSum))
                minDifference = Math.min(currentDifference, minDifference)
            }

            return minDifference
        }
    }
}