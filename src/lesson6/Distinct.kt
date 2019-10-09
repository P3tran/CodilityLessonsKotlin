package lesson6

/*
* Find the amount of distinct values in an array
* */

class Distinct {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(10 ,10 ,3, 4, 5, 4, 6, 6, 7))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            val set = hashSetOf<Int>()
            A.forEach {
                set.add(it)
            }
            return set.size
        }
    }
}