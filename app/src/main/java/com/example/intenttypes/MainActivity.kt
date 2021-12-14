package com.example.intenttypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var eml =findViewById<Button>(R.id.email)

         eml.setOnClickListener {
            sendemail()
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
}