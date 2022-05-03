package com.example.testingworkspace

import junit.framework.TestCase
import org.junit.Test

class RegistrationUtilTest : TestCase() {

    @Test
    fun testEmptyUsernameShouldReturnFalse() {
        // given
        val actual = RegistrationUtil.validateRegistrationInput("", "asdf1234", "asdf1234")

        // when
        val expected = false

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testEmptyPasswordShouldReturnFalse() {
        // given
        val actual = RegistrationUtil.validateRegistrationInput("Başar", "", "asdf1234")

        // when
        val expected = false

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testExistingUsernameShouldReturnFalse() {
        // given
        val actual = RegistrationUtil.validateRegistrationInput("Başar", "asdf1234", "asdf1234")

        // when
        val expected = false

        // then
        assertEquals(expected, actual)
    }


    @Test
    fun testSmallerThanTwoDigitPasswordShouldReturnFalse() {
        // given
        val actual = RegistrationUtil.validateRegistrationInput("Başar", "a", "a")

        // when
        val expected = false

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun testValidUsernameAndCorrectlyRepeatedPasswordShouldReturnTrue() {
        // given
        val actual = RegistrationUtil.validateRegistrationInput("İbrahim", "asdf1234", "asdf1234")

        // when
        val expected = true

        // then
        assertEquals(expected, actual)
    }
}