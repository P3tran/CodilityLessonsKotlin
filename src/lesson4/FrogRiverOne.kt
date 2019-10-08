package lesson4

class FrogRiverOne {

    /*
    * Minimum time to complete the path of falling leafs
    * */

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(6, intArrayOf(4,4,4,4,3,2,5,6,5))
            println("result :  $result")

        }

        fun solution(X: Int, A: IntArray): Int {

            if (X == 1)
                return 0
            val set = hashSetOf<Int>()

            for (i in 1..X) {
                set.add(i)
            }

            for (i in A.indices) {
                if (set.contains(A[i]))
                    set.remove(A[i])
                if(set.isEmpty())
                    return i
            }

            return -1
        }
    }
}