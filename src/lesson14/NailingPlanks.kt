package lesson14

/*
* calculate the minimum of nails to nail planks
* */

class NailingPlanks {

    companion object {

        data class Plank(val start: Int, val end: Int)

        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(1, 4, 5, 8), intArrayOf(4, 5, 9, 10), intArrayOf(4, 6, 7, 10, 2))
            println("result :  $result")

        }

        fun solution(A: IntArray, B: IntArray, C: IntArray): Int {
            val planks = mutableListOf<Plank>()
            for (i in A.indices) {
                planks.add(Plank(A[i], B[i]))
            }
            for (i in C.indices) {
                val plansToRemove = mutableListOf<Plank>()
                planks.forEach {
                    if (it.start <= C[i] && it.end >= C[i])
                        plansToRemove.add(it)
                }
                planks.removeAll(plansToRemove)
                if (planks.size == 0)
                    return i
            }
            return -1
        }


    }
}