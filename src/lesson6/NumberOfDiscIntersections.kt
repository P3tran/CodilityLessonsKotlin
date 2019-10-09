package lesson6

/*
* Check whether the discs intersect
* */

class NumberOfDiscIntersections {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(10, 10, 10, 5, 5, 12, 60, 13, 7, 10, 10, 10, 10))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            var counter = 0
            if (A.size < 2)
                return 0

            for (i in 0 until A.size - 1) {
                for (j in i + 1 until A.size) {
                    if (A[i] + A[j] >= j - i) {
                        counter++
                        if (counter > 10000000)
                            return -1
                    }
                }
            }
            return counter
        }
    }
}