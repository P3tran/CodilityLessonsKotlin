package lesson10

import kotlin.math.sqrt

/*
* Find the number of factors for an integer.
* Search until sqrt N, take take of edge cases around sqrt(N)
* */

class CountFactors {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(86)
            println("result :  $result")

        }

        fun solution(N: Int): Int {
            var factors = 0
            if (N == 1)
                return 1
            var squareRootN = sqrt(N.toDouble()).toInt()

            if (squareRootN * squareRootN == N)
                factors++
            else
                squareRootN++


            for (i in 1 until squareRootN) {
                if (N.rem(i) == 0)
                    factors += 2
            }


            return factors
        }
    }
}