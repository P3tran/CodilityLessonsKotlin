package lesson5

/*
* count the number of divisors within a range of numbers
* */

class CountDiv {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(2, 24, 3)
            println("result :  $result")
        }

        fun solution(A: Int, B: Int, K: Int): Int {
            var divisors = 0

            if (K > B) {
                return if (A == 0 || B == 0) {
                    1
                } else 0
            }

            if (A == 0) {
                divisors++
            }

            var updatedA = A
            if (K > A) {
                updatedA = K
            }

            var firstNonZeroDivisor = 0
            var lastNonZeroDivisor = 0

            for (i in updatedA..B) {
                if (i % K == 0) {
                    firstNonZeroDivisor = i
                    break
                }
            }
            for (i in B downTo updatedA) {
                if (i % K == 0) {
                    lastNonZeroDivisor = i
                    break
                }
            }
            if (firstNonZeroDivisor == 0 && lastNonZeroDivisor == 0) {
                divisors = 0
            } else {
                divisors += (lastNonZeroDivisor - firstNonZeroDivisor) / K + 1
            }

            return divisors
        }
    }
}
