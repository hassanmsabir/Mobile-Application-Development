package com.example.intenttypes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var eml =findViewById<Button>(R.id.email)

         eml.setOnClickListener {
            sendemail()
        }


        val alarmBtn = findViewById<Button>(R.id.alarmBtn)

        alarmBtn.setOnClickListener(){

            val messageBtn = findViewById<EditText>(R.id.alarmMsgET)
            val hourBtn = findViewById<EditText>(R.id.hourET)
            val minuteBtn = findViewById<EditText>(R.id.minuteET)

            val messageText = messageBtn.text.toString()
            val hourVal= hourBtn.text.toString()
            val hours:Int = 4
            Toast.makeText(this, hourVal, Toast.LENGTH_SHORT).show()
            val minuteVal = minuteBtn.text.toString()
            val minutes :Int =30

            this.createAlarm(messageText, hours, minutes)
    }
    }
      private fun sendemail() {
        var emil = arrayOf("Nabeel2525.na@gmail.com")
        var subject = "subjectname"
        var body = "txtmessage"
        var ei = Intent()
        ei.setAction(Intent.ACTION_SEND)
        ei.setType("message/rfc822")
        ei.putExtra(Intent.EXTRA_EMAIL,emil)
        ei.putExtra(Intent.EXTRA_SUBJECT,subject)
        ei.putExtra(Intent.EXTRA_TEXT,body)
        startActivity(ei)
        Toast.makeText(this, "open the email ", Toast.LENGTH_SHORT).show()

    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }


    }