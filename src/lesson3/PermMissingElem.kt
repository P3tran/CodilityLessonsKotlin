package lesson3

class PermMissingElem {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(1, 2, 3, 5, 4, 7, 8, 6))
            println("result :  $result")

        }

        fun solution(A: IntArray): Int {
            val set = hashSetOf<Int>()
            if(A.isEmpty())
                return 1

            A.forEach {
                set.add(it)
            }
            for (i in 1 .. A.size+1) {
                if(!set.contains(i))
                    return i
            }
            return 1
        }
    }
}