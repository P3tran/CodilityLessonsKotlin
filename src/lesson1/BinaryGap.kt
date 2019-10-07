package lesson1

class BinaryGap {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(1000000001)
            println("result :  $result")
        }
    }
}

fun solution(N: Int): Int {
    val binary = Integer.toBinaryString(N)
    println(binary)
    var maxGap = 0
    if (binary.length < 3)
        return maxGap

    var isCounting = false
    var runningGap = 0

    for (i in binary.indices) {
        if (binary[i] == '1') {
            if (isCounting) {
                maxGap = Math.max(runningGap, maxGap)
                runningGap = 0
            } else
                isCounting = true
        } else
            runningGap++
    }
    return maxGap
}