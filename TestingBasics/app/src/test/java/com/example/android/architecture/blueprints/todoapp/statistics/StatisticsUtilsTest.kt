package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
//        Assert.assertEquals(result.activeTasksPercent, 100f)
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test(expected = java.lang.NullPointerException::class)
    fun getActiveAndCompletedStats_nullTask_returnsException() {
        // Given
        val tasks = null

        try {
            // When
            getActiveAndCompletedStats(tasks)
        } catch (n: Exception) {
            // Then
            assertThat(n, `is`(NullPointerException::class))
        }
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsActiveTaskPercentZero() {
        // given
        val tasks = listOf(
            Task("title", "desc", isCompleted = true)
        )
        // when
        val result = getActiveAndCompletedStats(tasks)
        // then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_threeActiveTwoPassive_returnsActiveTaskPercentSixtyAndCompletedTaskPercentForty() {
        // given
        val tasks = listOf(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // when
        val result = getActiveAndCompletedStats(tasks)
        // then
        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))
    }

    @Test
    fun getActiveAndCompletedStats_noTask_returnsZeros() {
        // given
        val tasks = emptyList<Task>()
        // when
        val result = getActiveAndCompletedStats(tasks)
        // then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZeros() {
        // given
        val tasks = null
        // when
        val result = getActiveAndCompletedStats(tasks)
        // then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}