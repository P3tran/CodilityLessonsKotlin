package lesson2

class OddOccurrencesInArray {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(10,9,8,3,10,9,8,3,4))
            println("result :  $result")
        }
    }
}


fun solution(A: IntArray): Int {
    val set = hashSetOf<Int>()
    A.forEach {
        if(set.contains(it))
            set.remove(it)
        else
            set.add(it)
    }

    return set.first()
}

