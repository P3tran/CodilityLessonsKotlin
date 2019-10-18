package codilitychallenges

/*
* Find the minimum index that contains all discrete array items
* */

class Alpha2010 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result =
                solution(intArrayOf(2, 2, 1, 0, 1))
            println("result :  $result")
        }

        fun solution(A: IntArray): Int {
            val set = hashSetOf<Int>()
            if (A.size == 1)
                return 0
            A.forEach {
                set.add(it)
            }
            for (i in A.indices) {
                set.remove(A[i])
                if (set.isEmpty())
                    return i
            }

            return A.size - 1
        }

    }
}