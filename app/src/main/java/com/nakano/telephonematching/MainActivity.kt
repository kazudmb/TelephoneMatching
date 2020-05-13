package com.nakano.telephonematching

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdView : AdView = findViewById(R.id.adView)
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111")
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        button_call.setOnClickListener {
            val intent = Intent(this, TelephoneActivity::class.java)
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
