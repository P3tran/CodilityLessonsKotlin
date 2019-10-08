package lesson2

class CyclicRotation {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(10, 9, 8, 3, 10, 9, 8, 3, 4), 3)
            result.forEach {
                println("item :  $it")
            }

        }

        fun solution(A: IntArray, K: Int): IntArray {
            val result = IntArray(A.size)

            if (A.size <= 1 || K == 0)
                return A

            val times =
                if (K >= A.size)
                    K.rem(A.size)
                else K

            if(times == 0)
                return A

            var j = 0

            for (i in 0 until times) {
                result[times-i-1] = A[A.size -1 -i]
            }

            for (i in times until A.size) {
                result[i] = A[j]
                j++
            }

            return result
        }
    }
}


