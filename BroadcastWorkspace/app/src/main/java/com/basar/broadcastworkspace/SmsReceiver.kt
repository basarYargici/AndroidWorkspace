package com.basar.broadcastworkspace

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (!isSmsReceivedAction(intent)) return
        val extractMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        val message = extractMessages.last().displayMessageBody

        Toast.makeText(context, "SMS RECEIVED: $message", Toast.LENGTH_LONG).show();
    }

    // SMS Receiver should only check SMS broadcasts
    private fun isSmsReceivedAction(intent: Intent?) =
        intent?.action?.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION) == true
}