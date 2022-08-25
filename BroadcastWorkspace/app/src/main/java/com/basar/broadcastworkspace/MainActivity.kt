package com.basar.broadcastworkspace

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Telephony.Sms.Intents.SMS_RECEIVED_ACTION
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.basar.broadcastworkspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_SMS_PERMISSION = 1
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var airplaneModeChangeReceiver: AirplaneModeChangeReceiver
    private lateinit var smsReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestSmsPermission()

        airplaneModeChangeReceiver = AirplaneModeChangeReceiver()
        smsReceiver = SmsReceiver()

        // Intent Filter is useful to determine which apps wants to receive which intents.
        // Since here we want to respond to change of airplane mode, we are using ACTION_AIRPLANE_MODE_CHANGED
        registerAirplaneModeReceiver()
        registerSmsReceiver()
    }

    private fun registerSmsReceiver() {
        IntentFilter(SMS_RECEIVED_ACTION).also {
            registerReceiver(smsReceiver, it)
        }
    }

    private fun registerAirplaneModeReceiver() {
        IntentFilter(ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneModeChangeReceiver, it)
        }
    }

    private fun requestSmsPermission() {
        val permission = Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, permission)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), REQUEST_CODE_SMS_PERMISSION)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_SMS_PERMISSION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Log.v("SMS: ", "Agree Sms permission")
                else
                    Log.v("SMS: ", "You did not agree Sms permission")
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airplaneModeChangeReceiver)
        unregisterReceiver(smsReceiver)
    }
}