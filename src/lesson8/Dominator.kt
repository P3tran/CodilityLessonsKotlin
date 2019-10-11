package lesson8

import java.util.*

/*
* Find the leader of an array, the number the occurs more than half times by using a stack.
* */

class Dominator {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(4, 6, 4, 4, 5, 6, 4))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            if (A.isEmpty())
                return -1
            val stack = Stack<Int>()
            var leaderIndex = 0
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
                return -1
            val candidate = stack.pop()
            var candidateOccurrences = 0
            for (i in A.indices) {
                if (A[i] == candidate) {
                    leaderIndex = i
                    candidateOccurrences++
                }
            }
            if (candidateOccurrences > (A.size / 2))
                return leaderIndex
            return -1
        }
    }
}