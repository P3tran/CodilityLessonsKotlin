package lesson5

/*
* Find the number of pairs that look at different directions. Zeros Left Ones Right.
* */

class PassingCars {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(0, 1, 0, 1, 1))
            println("result :  $result")
        }


        fun solution(A: IntArray): Int {
            var runningZeros = 0
            var passingCars = 0

            if (A.size < 2)
                return 0

            for (i in A.indices) {
                if (A[i] == 0) {
                    runningZeros++
                } else {
                    passingCars += runningZeros
                    if (passingCars > 1000000000)
                        return -1
                }
            }

            return passingCars
        }
    }
}