package lesson10

import kotlin.math.*

/*
* Calculate the minimum perimeter of possible rectangles with a given space.
* Calculate all possible factors until sqrt the other side is N/factor
* */

class MinPerimeterRectangle {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(36)
            println("result :  $result")

        }

        fun solution(N: Int): Int {
            var squareRootN = sqrt(N.toDouble()).toInt()
            if (N == 1)
                return 4
            squareRootN++
            var runningMin = Integer.MAX_VALUE

            for (i in 1 until squareRootN) {
                if (N.rem(i) == 0) {
                    runningMin = min(runningMin, 2 * (i + N / i))
                }
            }
            return runningMin
        }
    }
}