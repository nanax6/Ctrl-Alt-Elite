package com.example.parquescolombia.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.parquescolombia.R
import com.example.parquescolombia.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val splashScreen = AnimationUtils.loadAnimation(this, R.anim.splash_fadein)
        mainTitle.startAnimation(splashScreen)

        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                startActivity(
                    Intent(this@SplashActivity2,
                        MainActivity::class.java)
                )
                finish()
            }, 4000
        )

    }



}