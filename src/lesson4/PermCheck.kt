package lesson4

class PermCheck {

    /*
    * Check is an array is a permutation.
    * Contains all integers within the range size of the array only once.
    * */

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(1, 2, 3, 5, 4, 7, 8, 6))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            val set = hashSetOf<Int>()
            A.forEach {
                if (it > A.size)
                    return 0
                if (set.contains(it))
                    return 0
                else
                    set.add(it)
            }
            for (i in 1..A.size) {
                if(!set.contains(i))
                    return 0
            }

            return 1
        }
    }
}