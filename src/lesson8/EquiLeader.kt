package lesson8

import java.util.*

/*
* Find leaders in 2 array slices by checking if leader exists
* and using prefix occurrences sums after, on  all array slices
* */

class EquiLeader {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(4, 3, 4, 4, 4, 2))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            if (A.size < 2)
                return 0
            val stack = Stack<Int>()
            for (i in A.indices) {
                stack.push(A[i])
            }

            for (i in A.indices) {
                when {
                    stack.isEmpty() -> stack.push(A[i])
                    stack.peek() != A[i] -> stack.pop()
                    else -> stack.push(A[i])
                }
            }

            if (stack.size == 0)
                return 0
            val candidate = stack.pop()
            var candidateOccurrences = 0
            val sumOccurrences = IntArray(A.size) {0}
            var equis = 0

            for (i in A.indices) {
                if (A[i] == candidate) {
                    candidateOccurrences++
                    if (i > 0)
                        sumOccurrences[i] = sumOccurrences[i - 1] + 1
                    else
                        sumOccurrences[i] = 1
                } else {
                    if (i > 0)
                        sumOccurrences[i] = sumOccurrences[i - 1]
                    else
                        sumOccurrences[i] = 0
                }

            }

            if (candidateOccurrences > (A.size / 2)) {
                println("we have a leader $candidate")
                for (i in A.indices) {
                    println("in index $i : ")
                    println("sum occ from start: ${sumOccurrences[i]}, occur from end: ${sumOccurrences[A.size-1] - sumOccurrences[i]}")
                    println("compared to ${i+1/2} and compared to ${(A.size -1 - i)/2 }")

                    if(sumOccurrences[i] > (i+1).toDouble() /2 && ((sumOccurrences[A.size-1] - sumOccurrences[i]) > (A.size -1 - i).toDouble()  /2 )) {
                        equis++
                        println("bingo")
                    }
                }
                return equis
            }

            return 0
        }
    }
}