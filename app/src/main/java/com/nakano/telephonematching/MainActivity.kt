package com.nakano.telephonematching

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.tool_bar)
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        val mAdView : AdView = findViewById(R.id.adView)
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111")
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        button_login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        button_call.setOnClickListener {
            val intent = Intent(this, TelephoneActivity::class.java)
            startActivity(intent)
        }

        button_profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        button_profile_setting.setOnClickListener {
            val intent = Intent(this, ProfileSettingActivity::class.java)
            startActivity(intent)
        }
    }
}
