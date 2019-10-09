package lesson5

import kotlin.math.min

/*
* Find the minimum slice sum average in an array
* */

/*
* 100% solution is to find the minimum average by checking only 2 and 3 contiguous elements at a time.
* */

class MinAvgTwoSlice {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(-4, 4, 4, 7, -3, -4, 3, 2, 5, 6, 5))
            println("result :  $result")
        }

        fun solution(A: IntArray): Int {
            var min = Double.MAX_VALUE
            var minIndex = 0

            for (i in A.indices) {
                var runningSum = A[i]
                for (j in i+1 until A.size) {
                    runningSum += A[j]
                    val sumAverage = runningSum.toDouble() / (j - i + 1)
                    if(sumAverage < min) {
                        min = min(sumAverage, min)
                        minIndex = i
                    }
                }
            }

            println(min)
            return minIndex
        }
    }
}