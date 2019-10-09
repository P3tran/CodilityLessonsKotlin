package lesson7

import java.util.*

/*
* Check where all parentheses and brackets open and close properly using stack
* */

class Brackets {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = solution("{()[(())]{((()))}{}()(())()()()}")
            println("result :  $result")

        }

        fun solution(S: String): Int {
            val stack = Stack<Char>()
            for (i in S.indices) {
                if (isLeft(S[i])) {
                    stack.push(S[i])
                } else {
                    if (stack.isEmpty())
                        return 0
                    if (isMatching(S[i], stack.pop())) {

                    } else
                        return 0
                }
            }
            if (stack.isEmpty())
                return 1
            return 0
        }

        private fun isMatching(char: Char?, pop: Char): Boolean {
            if ((pop == '(' && char == ')') ||
                pop == '[' && char == ']' ||
                pop == '{' && char == '}'
            ) return true
            return false
        }

        private fun isLeft(c: Char): Boolean {
            if (c == '(' ||
                c == '[' ||
                c == '{'
            ) return true
            return false
        }
    }
}