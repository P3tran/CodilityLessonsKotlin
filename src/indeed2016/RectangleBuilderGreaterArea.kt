package indeed2016

/*
* This has scored only 15%
* */

class RectangleBuilderGreaterArea {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(2,3,4,6 ,7 ,1,2,3,4,6,7) , 10)
            println("result :  $result")

        }

        fun solution(A: IntArray, X: Int): Int {
            var ways = 0
            val doublePlanks = mutableSetOf<Int>()
            val set = mutableSetOf<Int>()
            val planksToUse = mutableListOf<Int>()
            if (A.size < 4)
                return 0

            A.forEach {
                if(!set.contains(it))
                    set.add(it)
                else {
                    if(!doublePlanks.contains(it)) {
                        doublePlanks.add(it)
                        planksToUse.add(it)
                    } else {
                        doublePlanks.remove(it)
                    }


                    set.remove(it)
                }
            }

            for(i in 0 until planksToUse.size-1) {
                for(j in i+1 until planksToUse.size) {
                    if(planksToUse[i] * planksToUse[j] >= X) {
                        ways++
                        if(ways > 1000000000)
                            return -1
                    }
                }
            }
            return ways
        }

    }
}