package com.example.testingworkspace

import junit.framework.TestCase
import org.junit.Test

class WorkspaceTest : TestCase() {

    @Test
    fun testTwoPlusThreeShouldReturnFive() {
        // given
        val actual = Workspace().sumTwoIntegers(2, 3)

        // when
        val expected = 5

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testNumberZeroShouldReturnZero() {
        // given
        val actual = Workspace().fib(0)

        // when
        val expected = 0L

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testNumberOneShouldReturnOne() {
        // given
        val actual = Workspace().fib(1)

        // when
        val expected = 1L

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testNumberThreeShouldReturnTwo() {
        // given
        val actual = Workspace().fib(3)

        // when
        val expected = 2L

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testNumberFiveShouldReturnFive() {
        // given
        val actual = Workspace().fib(5)

        // when
        val expected = 5L

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testOneOpeningOneClosingParenthesisShouldReturnTrue() {
        // given
        val actual = Workspace().checkBrace("(a*b)")

        // when
        // then
        assertTrue(actual)
    }

    @Test
    fun testOneOpeningTwoClosingParenthesisShouldReturnFalse() {
        // given
        val actual = Workspace().checkBrace("(a*b))")

        // when
        // then
        assertFalse(actual)
    }

    @Test
    fun testZeroOpeningZeroClosingParenthesisShouldReturnTrue() {
        // given
        val actual = Workspace().checkBrace("a*b")

        // when
        // then
        assertTrue(actual)
    }
}