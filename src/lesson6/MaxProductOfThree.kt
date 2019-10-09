package lesson6

import kotlin.math.max

/*
* Find the max product of three numbers in an array x * y * d = max
* */

class MaxProductOfThree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(10, -40, -10, 4, 3, 2, 5, 6, 10))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            val sorted = A.sorted()
            val maxNeg = sorted[0]
            val secMaxNeg = sorted[1]
            val max = sorted[A.size - 1]
            val secMax = sorted[A.size - 2]
            val thirdMax = sorted[A.size - 3]

            val twoNegAndMax = maxNeg * secMaxNeg * max
            val threeMax = max * secMax * thirdMax

            return max(twoNegAndMax, threeMax)
        }
    }
}