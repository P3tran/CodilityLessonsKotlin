package lesson7

import java.util.*

/*
* Fish moving in different directions eat each other, use stack and loop to calculate remaining fish
* */

class Fish {
    data class Fish(val w: Int, val d: Int)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution(intArrayOf(4, 3, 2, 1, 5), intArrayOf(0, 1, 0, 0, 0))
            println("result :  $result")

        }

        fun solution(A: IntArray, B: IntArray): Int {
            val stack = Stack<Fish>()
            if (A.size < 2)
                return A.size
            for (i in B.indices) {
                val fish = Fish(A[i], B[i])
                if (isMovingUp(fish.d)) {
                    if (stack.isEmpty()) {
                        stack.push(fish)
                    } else if (isMovingDown(stack.peek().d)) {
                        while (!stack.isEmpty()) {
                            if (stack.peek().d == fish.d) {
                                stack.push(fish)
                                break;
                            } else {
                                if (stack.peek().w > fish.w) {
                                    break
                                } else {
                                    stack.pop();
                                    continue
                                }
                            }
                        }
                        if (stack.isEmpty()) {
                            stack.push(fish)
                        }
                    } else {
                        stack.push(fish)
                    }
                } else {
                    stack.push(fish)
                }
            }
            return stack.size
        }

        private fun isMovingUp(i: Int): Boolean {
            return i == 0
        }

        private fun isMovingDown(i: Int): Boolean {
            return i == 1
        }
    }
}