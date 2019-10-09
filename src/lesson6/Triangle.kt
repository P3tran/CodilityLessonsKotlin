package lesson6

/*
* Find whether an array contains a triangle by sorted and comparing neighbors.
* Requires usage of long because adding Max Integer and storing it in Int will cause overflow.
*/

class Triangle {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(10, 10, 10, 5, 5, 12, 60, 13, 7, 10, 10, 10, 10))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            if (A.size < 3)
                return 0
            val sorted = A.sorted()
            val list = arrayListOf<Long>()
            sorted.forEach {
                list.add(it.toLong())
            }

            for (i in 0 until sorted.size - 2) {
                if (isTriplet(list[i], list[i + 1], list[i + 2])) {
                    println("is triplet for ${sorted[i]}, ${sorted[i + 1]}, ${sorted[i + 2]}")
                    return 1
                }
            }
            return 0
        }

        private fun isTriplet(i: Long, i1: Long, i2: Long): Boolean {
            if (i + i1 > i2 &&
                i + i2 > i1 &&
                i1 + i2 > i
            ) return true
            return false
        }
    }
}
