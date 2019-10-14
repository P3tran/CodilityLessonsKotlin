package lesson10

import java.util.ArrayList
import kotlin.math.abs

class Flags {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {

            val peaksIndexes = ArrayList<Int>()

            for (i in 1 until A.size - 1) {
                if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                    peaksIndexes.add(i)
                }
            }

            for (i in peaksIndexes.size downTo 0) {
                for(j in 1 until peaksIndexes.size) {
                    var droppedFlags = 0
                    if(abs(peaksIndexes[j] - peaksIndexes[j-1]) >= i) {
                        if(j == peaksIndexes.size-1)
                            return i
                    } else {
                        droppedFlags++
                        if(peaksIndexes.size - droppedFlags < i)
                            break
                    }
                }
            }

            return 0
        }
    }
}