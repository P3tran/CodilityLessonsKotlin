package lesson3

/*
* Find the minimum steps to cover distance.
* */

class FrogJmp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(10, 150, 10)
            println("result :  $result")

        }

        fun solution(X: Int, Y: Int, D: Int): Int {
            val distanceToCover = Y - X
            if (distanceToCover == 0)
                return 0

            if(distanceToCover.rem(D) == 0)
                return distanceToCover/D
            else
                return distanceToCover/D +1
        }
    }
}
