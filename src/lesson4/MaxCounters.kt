package lesson4

import kotlin.math.max

/*
*  Apply set of operations in array and calc the last values
*/

class MaxCounters {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(6, intArrayOf(4, 4, 4, 7, 3, 2, 5, 6, 5))
            result.forEach {
                print(" $it")
            }
        }

        fun solution(N: Int, A: IntArray): IntArray {
            val counters = IntArray(N) { 0 }
            var max = 0
            var runningMax = 0

            for (i in A.indices) {
                if (A[i] >= N + 1) {
                    runningMax = max
                } else {
                    if (counters[A[i] - 1] < runningMax) {
                        counters[A[i] - 1] = runningMax
                    }
                    counters[A[i]-1]++;
                    max = max(max, counters[A[i] - 1])
                }
            }

            for (i in counters.indices) {
                if (counters[i] < runningMax)
                    counters[i] = runningMax
            }

            return counters
        }
    }
}