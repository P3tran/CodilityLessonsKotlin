package lesson7

import java.util.*

/*
* Build a stone wall by re-using rocks when possible using a stack
* */

class StoneWall {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(4, 6, 4, 4, 5 , 6 , 4))
            println("result :  $result")
        }

        fun solution(H: IntArray): Int {
            var blocks = 0
            val stack = Stack<Int>()

            for (i in H.indices) {
                if (stack.isEmpty()) {
                    stack.push(H[i])
                    blocks++
                } else if (stack.peek() == H[i]) {
                    continue
                } else if (stack.peek() < H[i]) {
                    blocks++
                    stack.push(H[i])
                } else if (stack.peek() > H[i]) {
                    while (!stack.isEmpty() && stack.peek() > H[i]) {
                        stack.pop()
                    }
                    if (!stack.isEmpty() && stack.peek() == H[i]) {
                        continue
                    } else {
                        stack.push(H[i])
                        blocks++
                    }
                }
            }
            return blocks
        }
    }
}