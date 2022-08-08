package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


/**
 *
 * When you have a local test where you need simulated Android framework classes (such as an Application Context), follow these steps to properly set up AndroidX Test:
 * - Add the [AndroidX Test core and ext dependencies](https://developer.android.com/training/testing/instrumented-tests/androidx-test-libraries/test-setup)
 * - Add the [Robolectric](http://robolectric.org) Testing library dependency
 * - Annotate the class with the AndroidJunit4 test runner
 * - Write AndroidX Test code
 *
 * One of the benefits of the AndroidX Test APIs is that they are built to work both for local tests and instrumented tests. This is nice because:
 * - You can run the same test as a local test or an instrumented test.
 * - You don't need to learn different testing APIs for local vs. instrumented tests.
 * - You can move your Test class from the test folder to the androidTest folder and the tests will still run.
 *
 * Robolectric
 * - The simulated Android environment that AndroidX Test uses for local tests is provided by Robolectric.
 * - Robolectric is a library that creates a simulated Android environment for tests
 *
 * Robolectric
 * - The simulated Android environment that AndroidX Test uses for local tests is provided by Robolectric.
 * - Robolectric is a library that creates a simulated Android environment for tests
 *
 * In summary:
 * - Pure view model tests can usually go in the test source set because their code doesn't usually require
 * Android.
 * - You can use the AndroidX test library to get test versions of components like Applications and
 * Activities.
 * - If you need to run simulated Android code in your test source set, you can add the Robolectric dependency
 * and the @RunWith(AndroidJUnit4::class) annotation.
 */
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    @Test
    fun addNewTask_setsNewTaskEvent() {
        // Given a fresh ViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task
        tasksViewModel.addNewTask()

        // Then the new task event is triggered

    }
}