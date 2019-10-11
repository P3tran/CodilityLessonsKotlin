package lesson9

import kotlin.math.max
import kotlin.math.min

/*
* Calculate the maximum difference inside an array by keeping the running min value.
* */

class MaxProfit {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(4, 6, 4, 4, 5, 6, 4))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            if (A.size < 2)
                return 0
            var runningMin = Integer.MAX_VALUE
            var maxDiff = 0
            for (i in A.indices) {
                runningMin = min(runningMin, A[i])
                maxDiff = max(maxDiff, A[i] - runningMin)
            }
            if (maxDiff > 0)
                return maxDiff
            return 0
        }
    }
}