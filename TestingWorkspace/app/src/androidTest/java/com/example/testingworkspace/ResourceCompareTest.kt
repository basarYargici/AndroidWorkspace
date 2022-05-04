package com.example.testingworkspace

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ResourceCompareTest {

    // bad practice, functions rely on same instance, but they should be independent
    private lateinit var resourceComparer: ResourceCompare

    // before each case, it is reinitialized
    @Before
    fun setup() {
        resourceComparer = ResourceCompare()
    }

    @Test
    fun testStringResourceSameAsGivenString_returnsTrue() {
        // given
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "TestingWorkspace")

        // when
        // then
        assertThat(result).isTrue()
    }

    @Test
    fun testStringResourceSameAsGivenString_returnsFalse() {
        // given
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "X")

        // when
        // then
        assertThat(result).isFalse()
    }
}
