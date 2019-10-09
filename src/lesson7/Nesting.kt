package lesson7

import java.util.*

/*
* find whether string parentheses open and close properly by using a stack
* */

class Nesting {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution("()(())((()))()(())()()()")
            println("result :  $result")

        }

        fun solution(S: String): Int {
            val stack = Stack<Char>()
            for (i in S.indices) {
                if (isLeft(S[i])) {
                    stack.push('(')
                } else {
                    if(stack.isEmpty())
                        return 0
                    stack.pop()
                }
            }
            if(stack.isEmpty())
                return 1
            return 0
        }

        private fun isLeft(c: Char): Boolean {
            if (c == '(')
                return true
            return false
        }
    }
}