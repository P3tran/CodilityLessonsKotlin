package codilitychallenges

/*
* Find the number of disc intersections
* */

class Beta2010 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result =
                solution(intArrayOf(2, 2, 1, 0, 1))
            println("result :  $result")
        }

        fun solution(A: IntArray): Int {
            if (A.size < 2)
                return 0
            var intersections = 0
            for (i in 0 until A.size - 1) {
                for (j in i + 1 until A.size) {
                    if (A[i] + A[j] >= j - i) {
                        intersections++
                        if (intersections > 10000000)
                            return -1
                    }
                }
            }
            return intersections
        }
    }
}