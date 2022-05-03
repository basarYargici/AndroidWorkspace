package com.example.testingworkspace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Where should be our tests?
 * test -> Unit
 * androidTest (specific to android) -> Integration, UI
 *
 * Scope:
 * - Unit tests or small tests only verify a very small portion of the app, such as a method or class.
 * - End-to-end tests or big tests verify larger parts of the app at the same time, such as a whole screen or
 * user flow.
 * - Medium tests are in between and check the integration between two or more units.

 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}