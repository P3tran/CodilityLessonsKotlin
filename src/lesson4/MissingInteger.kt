package lesson4

/*
* Find the smallest int that the array does not contain
**/

class MissingInteger {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(4, 4, 4, 7, 3, 2, 5, 6, 5))
            println("result :  $result")
        }

        fun solution(A: IntArray): Int {
            val set = hashSetOf<Int>()

            for (i in A.indices) {
                if (A[i] > 0)
                    set.add(A[i])
            }

            for (i in 1..Int.MAX_VALUE)
                if (!set.contains(i))
                    return i

            return Int.MAX_VALUE
        }
    }
}