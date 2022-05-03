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
}