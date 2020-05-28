package com.nakano.telephonematching

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nakano.telephonematching.Login.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login_anonymous.setOnClickListener {
            val intent = Intent(this, LoginAnonymousActivity::class.java)
            startActivity(intent)
        }

        button_login_email.setOnClickListener {
            val intent = Intent(this, LoginEmailActivity::class.java)
            startActivity(intent)
        }

        button_login_google.setOnClickListener {
            val intent = Intent(this, LoginGoogleActivity::class.java)
            startActivity(intent)
        }

        button_login_twitter.setOnClickListener {
            val intent = Intent(this, LoginTwitterActivity::class.java)
            startActivity(intent)
        }

        button_login_facebook.setOnClickListener {
            val intent = Intent(this, LoginFacebookActivity::class.java)
            startActivity(intent)
        }

        button_login_phone.setOnClickListener {
            val intent = Intent(this, LoginPhoneActivity::class.java)
            startActivity(intent)
        }
    }
}
