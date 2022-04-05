package com.example.mailsender

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var edMail: EditText? = null
    var edTitle: EditText? = null
    var edText: EditText? = null
    var button: Button? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edMail = findViewById(R.id.editTextTextEmailAddress)
        edTitle = findViewById(R.id.editTextTextEmailAddress2)
        edText = findViewById(R.id.ed_text)
        button = findViewById(R.id.b_send)

        button?.setOnClickListener{
            button?.isEnabled = false;
            val text: String =   "" + edMail?.getText() + "\n"+ "\n" + edText?.getText()
            val title = edTitle?.getText().toString()


            GlobalScope.launch {
                try {
                    val sender = GMailSender(
                        "leshinintimur@gmail.com",
                        "79tovuro"
                    )
                    sender.sendMail(
                        title, text,
                        "leshinintimur@gmail.com", "leshinintimur@gmail.com"
                    )

                } catch (e: Exception) {

                }
                withContext(Dispatchers.Main) {
                    button?.isEnabled = true;
                }
            }

        }
    }


}


