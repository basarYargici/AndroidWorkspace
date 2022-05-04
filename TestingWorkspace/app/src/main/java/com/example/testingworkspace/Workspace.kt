package com.example.testingworkspace

class Workspace {
    fun sumTwoIntegers(numberA: Int, numberB: Int) = numberA + numberB

    /**
     * Returns n-th fibonacci number
     * fib(0) = 0
     * fib(1) = 1
     * fib(n) = fib(n-2) + fib(n-1)
     */
    fun fib(n: Int): Long {
        if (n == 0 || n == 1) {
            return n.toLong()
        }
        var a = 0L
        var b = 1L
        var c = 1L
        (1 until n).forEach { i ->
            c = a + b
            a = b
            b = c
        }
        return c
    }

    /**
     * checks brace correctness
     * e.g. "(a*b))" should return false
     */
    fun checkBrace(string: String): Boolean {
        return string.count { it == '(' } == string.count { it == ')' }
    }
}
