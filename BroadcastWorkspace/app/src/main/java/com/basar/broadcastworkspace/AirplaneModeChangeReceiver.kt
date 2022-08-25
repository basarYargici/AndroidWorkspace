package com.basar.broadcastworkspace

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false)

        isAirplaneModeEnabled?.let {
            val message = if (it) "Airplane Mode Enabled" else "Airplane Mode Disabled"
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}